package org.overtime.repository;

import org.overtime.beans.CompensateType;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ForteScarlet
 */
// @Repository
public interface TestCompensateTypeRepository extends ReactiveCrudRepository<CompensateType, Long> {
}
