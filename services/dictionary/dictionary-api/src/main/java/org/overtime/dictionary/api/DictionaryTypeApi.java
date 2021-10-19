package org.overtime.dictionary.api;

import org.overtime.dictionary.domain.DictionaryType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 字典类型 {@code dictionaryType} 对外API。
 * @author ForteScarlet
 */
@ReactiveFeignClient(DictionaryApiConstant.APPLICATION_NAME)
// @RequestMapping(DictionaryTypeApi.API_REQ_MAPPING) // no
public interface DictionaryTypeApi extends DictionaryApiSupport {
    String API_REQ_MAPPING = "/dictionaryType";
    String ALL = API_REQ_MAPPING + "/all";

    /**
     * 查询所有的字典类型。
     * @return 所有的字典类型。
     */
    @GetMapping(ALL)
    Flux<DictionaryType> all();

    String GET = API_REQ_MAPPING + "/get/{id}";

    /**
     * 根据ID查询。
     * @param id id
     * @return {@link DictionaryType}
     */
    @GetMapping(GET)
    Mono<DictionaryType> get(@PathVariable("id") Long id);



}
