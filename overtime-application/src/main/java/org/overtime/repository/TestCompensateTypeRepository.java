package org.overtime.repository;

import org.overtime.beans.CompensateType;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@Repository
public interface TestCompensateTypeRepository extends ReactiveCrudRepository<CompensateType, Long> {

    /**
     * 取出第一条数据
     * @return The first data.
     */
    @Query("SELECT * FROM compensate_type LIMIT 1")
    Mono<CompensateType> first();

}
