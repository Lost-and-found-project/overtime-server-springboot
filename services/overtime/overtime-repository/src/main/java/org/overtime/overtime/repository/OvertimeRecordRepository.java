package org.overtime.overtime.repository;

import org.overtime.common.repository.StandardOvertimeRepository;
import org.overtime.overtime.domain.OvertimeRecord;
import org.springframework.stereotype.Repository;

/**
 * @author ForteScarlet
 */
@Repository
public interface OvertimeRecordRepository extends StandardOvertimeRepository<OvertimeRecord, Long> {
}
