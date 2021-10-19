package org.overtime.dictionary.controller;

import lombok.RequiredArgsConstructor;
import org.overtime.common.domain.CompensateType;
import org.overtime.compensate.api.CompensateTypeApi;
import org.overtime.dictionary.api.DictionaryTypeApi;
import org.overtime.dictionary.domain.DictionaryType;
import org.overtime.dictionary.service.DictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 字典类型控制器。
 *
 * @author ForteScarlet
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(DictionaryTypeApi.API_REQ_MAPPING)
public class DictionaryTypeController implements DictionaryTypeApi {
    private final DictionaryTypeService dictionaryTypeService;
    private final CompensateTypeApi compensateTypeApi;

    @GetMapping("/test")
    public Flux<CompensateType> test() {
        return compensateTypeApi.findByUserId(0L);
    }

    @Override
    @GetMapping(ALL)
    public Flux<DictionaryType> all() {
        return dictionaryTypeService.all();
    }

    @Override
    @GetMapping(GET)
    public Mono<DictionaryType> get(@PathVariable("id") Long id) {
        return dictionaryTypeService.get(id);
    }
}
