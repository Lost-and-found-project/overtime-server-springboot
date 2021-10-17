package org.overtime.repository.compensate;

import org.overtime.domain.CompensateType;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author ForteScarlet
 */
@Repository
public interface CompensateTypeRepository extends ReactiveCrudRepository<CompensateType, Long> {

    /**
     * 取出第一条数据
     *
     * @return The first data.
     */
    @Query("SELECT * FROM compensate_type WHERE user_id = :userId")
    Flux<CompensateType> findByUserId(@Param("userId") long userId);




}
