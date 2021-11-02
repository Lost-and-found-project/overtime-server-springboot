package org.overtime.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ForteScarlet
 */
// @SuppressWarnings("SpringFacetCodeInspection")
@Configuration
public class RouteRepository implements RouteDefinitionRepository {
    private final Map<String, RouteDefinition> routes = new ConcurrentHashMap<>(); // synchronizedMap(new LinkedHashMap<>());

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(r -> {
            String routeId = r.getId();
            if (ObjectUtils.isEmpty(routeId)) {
                return Mono.error(new IllegalArgumentException("id may not be empty"));
            }
            System.out.println("Save route(" + routeId + ") -> " + r);
            routes.put(routeId, r);
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            System.out.println("Remove route: " + id);
            if (routes.containsKey(id)) {
                routes.remove(id);
                return Mono.empty();
            }
            return Mono.defer(() -> Mono.error(new NotFoundException("RouteDefinition not found: " + routeId)));
        });
    }

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return Flux.fromIterable(routes.values());
    }


}
