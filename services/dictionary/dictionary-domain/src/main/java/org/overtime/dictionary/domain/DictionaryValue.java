package org.overtime.dictionary.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 字典值实体类
 *
 * @author ForteScarlet
 */
@Data
@Table("dictionary_value")
public final class DictionaryValue {
    /*
     * @param id    主键ID
     * @param parentId 父ID。如果为顶层，此为 -1
     * @param typeId 类型ID
     * @param name 名称
     * @param value 值
     * @param description 描述/备注
     * @param createTime 创建时间
     */

    @Id
    private Long id;
    private Long parentId;
    private Long typeId;
    private String name;
    private String value;
    private String description;
    private LocalDateTime createTime;

}
