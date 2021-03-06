package org.overtime.compensate.api;

import org.overtime.common.domain.CompensateType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;


/**
 * Resources interface.
 *
 * @author ForteScarlet
 */
@ReactiveFeignClient(value = CompensateConstant.APPLICATION_NAME, path = CompensateTypeApi.API_REQ_MAPPING)
// @RequestMapping(CompensateTypeApi.API_REQ_MAPPING)
public interface CompensateTypeApi {
    String API_REQ_MAPPING = "/compensateType";
    String FIND_BY_USER_ID = "/user/{userId}";

    /**
     * 对于 {@code /compensate/type/user/{userId}} 接口的资源提供约束。
     *
     * @param userId 用户ID
     * @return 补偿类型列表。
     */
    @GetMapping(FIND_BY_USER_ID)
    Flux<CompensateType> findByUserId(@PathVariable("userId") Long userId);

}
