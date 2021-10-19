package org.overtime.dictionary.service.impl;

import org.overtime.common.service.StandardReactiveCrudService;
import org.overtime.dictionary.domain.DictionaryType;
import org.overtime.dictionary.respository.DictionaryTypeRepository;
import org.overtime.dictionary.service.DictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * {@link org.overtime.dictionary.service.DictionaryTypeService}
 * 服务接口实现。
 *
 * @author ForteScarlet
 */
@Service
public class DictionaryTypeServiceImpl extends StandardReactiveCrudService<DictionaryType, Long, DictionaryTypeRepository> implements DictionaryTypeService {

    @Autowired
    DictionaryTypeServiceImpl(DictionaryTypeRepository repository) {
        super(repository);
    }

    @Override
    public Flux<DictionaryType> all() {
        return getRepository().findAll();
    }

    @Override
    public Mono<DictionaryType> get(Long id) {
        return getRepository().findById(id);
    }
}
