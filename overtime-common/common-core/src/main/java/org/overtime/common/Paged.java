package org.overtime.common;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

/**
 * 分页后的数据信息。
 *
 * @author ForteScarlet
 */
public record Paged<T>(
        Collection<T> values,
        PageInfo pageInfo
) {
    public static <T> Mono<Paged<T>> toPaged(Flux<T> flux, Mono<PageInfo> pageInfo) {
        final Mono<List<T>> collectList = flux.collectList();
        return Mono.zip(collectList, pageInfo).map(tuple -> new Paged<>(tuple.getT1(), tuple.getT2()));
    }

}
