package org.overtime.dictionary.service;

import org.overtime.dictionary.domain.DictionaryType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 字典类型服务接口
 *
 * @author ForteScarlet
 */
public interface DictionaryTypeService {

    /**
     * 查询所有的字典类型。
     *
     * @return {@link DictionaryType}
     */
    Flux<DictionaryType> all();


    /**
     * 根据ID查询字典类型。
     *
     * @param id id
     * @return {@link DictionaryType}
     */
    Mono<DictionaryType> get(Long id);


    /**
     * 创建一个新的类型。
     *
     * @param type id 会被置空，createTime会被覆盖.
     * @return {@link DictionaryType}
     */
    Mono<DictionaryType> create(DictionaryType type);


    /**
     * 修改一个新的类型。
     *
     * @param type id必须存在。
     * @return {@link DictionaryType}
     */
    Mono<DictionaryType> edit(DictionaryType type);

}
