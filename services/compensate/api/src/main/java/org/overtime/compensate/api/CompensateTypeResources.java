package org.overtime.compensate.api;

import org.overtime.compensate.domain.CompensateType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Resources interface.
 *
 * @author ForteScarlet
 */
// @FeignClient(Application Context Name)
@RestController("/compensate/type")
public interface CompensateTypeResources {

    /**
     * 对于 {@code /compensate/type/user/{userId}} 接口的资源提供约束。
     *
     * @param userId 用户ID
     * @return 补偿类型列表。
     */
    @GetMapping("/user/{userId}")
    Flux<CompensateType> findByUserId(@PathVariable("userId") Long userId);

}
