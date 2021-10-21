package org.overtime.dictionary.service.impl;

import org.overtime.common.service.StandardR2dbcService;
import org.overtime.dictionary.domain.DictionaryType;
import org.overtime.dictionary.repository.DictionaryTypeRepository;
import org.overtime.dictionary.service.DictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * {@link org.overtime.dictionary.service.DictionaryTypeService}
 * 服务接口实现。
 *
 * @author ForteScarlet
 */
@Service
public class DictionaryTypeServiceImpl extends StandardR2dbcService<DictionaryType, Long, DictionaryTypeRepository> implements DictionaryTypeService {

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

    @Override
    @Transactional
    public Mono<DictionaryType> create(DictionaryType type) {
        type.setId(null);
        type.setCreatTime(LocalDateTime.now());
        return getRepository().save(type);
    }

    @Override
    @Transactional
    public Mono<DictionaryType> edit(DictionaryType type) {
        // Maybe not 0 also?
        if (type.getId() == null) {
            throw new IllegalArgumentException("required DictionaryType.id was null: " + type);
        }
        return getRepository().save(type);
    }


}
