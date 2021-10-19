package org.overtime.dictionary.api;

import org.overtime.dictionary.domain.DictionaryType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 字典类型 {@code dictionaryType} 对外API。
 * @author ForteScarlet
 */
@FeignClient(DictionaryApiConstant.APPLICATION_NAME)
@RequestMapping("/dictionaryType")
public interface DictionaryTypeApi {

    /**
     * 查询所有的字典类型。
     * @return 所有的字典类型。
     */
    @GetMapping("/all")
    Flux<DictionaryType> all();

    /**
     * 根据ID查询。
     * @param id id
     * @return {@link DictionaryType}
     */
    @GetMapping("/get/{id}")
    Mono<DictionaryType> get(@PathVariable("id") Long id);



}
