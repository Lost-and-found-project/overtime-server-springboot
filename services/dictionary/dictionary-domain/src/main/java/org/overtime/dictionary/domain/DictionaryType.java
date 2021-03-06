package org.overtime.dictionary.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 字典类型实体类。
 *
 * @author ForteScarlet
 */
@Data
@Table("dictionary_type")
public final class DictionaryType {
    @Id
    private Long id;
    private String name;
    private String description;
    private LocalDateTime creatTime;
}
