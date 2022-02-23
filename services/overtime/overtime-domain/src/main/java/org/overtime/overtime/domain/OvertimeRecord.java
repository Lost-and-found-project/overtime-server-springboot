package org.overtime.overtime.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 表 overtime.overtime_record
 * @author ForteScarlet
 */
@Data
@Table
public class OvertimeRecord {

    @Id
    private Long id;
    private LocalDate overtimeDay;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean workingDay;
    private Boolean holiday;
    private Boolean businessTrip;
    private String companyName;
    private String companyCode;


}
