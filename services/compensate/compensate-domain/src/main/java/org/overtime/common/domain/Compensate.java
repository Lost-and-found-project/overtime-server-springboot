package org.overtime.common.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;


/**
 * 补偿。
 *
 * @author ForteScarlet
 */
@Data
public class Compensate {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    // @OneToOne
    // @JoinColumn(name = "type_id", unique = true, nullable = false, updatable = false)
    // R2DBC not support @OneToOne
    private CompensateType type;

    // TODO

}
