package org.overtime.dictionary.service;

import org.overtime.dictionary.domain.DictionaryType;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 字典类型服务接口
 * @author ForteScarlet
 */
public interface DictionaryTypeService {

    /**
     * 查询所有的字典类型。
     * @return {@link DictionaryType}
     */
    Flux<DictionaryType> all();


    /**
     * 根据ID查询字典类型。
     * @param id id
     * @return {@link DictionaryType}
     */
    Mono<DictionaryType> get(Long id);

}
