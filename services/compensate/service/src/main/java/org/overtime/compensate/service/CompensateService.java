package org.overtime.compensate.service;

import org.overtime.common.domain.CompensateType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 补偿类型相关服务接口
 *
 * @author ForteScarlet
 */
public interface CompensateService {

    /**
     * 查询某用户所设置的所有补偿类型。
     *
     * @param userId 用户id
     * @return {@link CompensateType 补偿类型}
     */
    Flux<CompensateType> findCompensateTypeByUserId(long userId);


    /**
     * 根据ID查询某个 {@link CompensateType 补偿类型}。
     *
     * @param id 补偿类型ID
     * @return {@link CompensateType 补偿类型}
     */
    Mono<CompensateType> findCompensateTypeById(long id);

}
