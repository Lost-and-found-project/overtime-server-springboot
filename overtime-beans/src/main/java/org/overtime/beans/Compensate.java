package org.overtime.beans;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 补偿。
 *
 * @author ForteScarlet
 */
@Data
@Entity
public class Compensate {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne
    @JoinColumn(name="type_id", unique=true, nullable=false, updatable=false)
    private CompensateType type;

    // TODO

}
