package org.overtime.dictionary.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 字典类型实体类。
 * @author ForteScarlet
 */
@Table("dictionary_type")
public record DictionaryType(
        @Id
        Long id,
        String name,
        String description
) {
}
