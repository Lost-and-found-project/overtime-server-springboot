package org.overtime.service.compensate.impl;

import org.overtime.domain.CompensateType;
import org.overtime.repository.compensate.CompensateTypeRepository;
import org.overtime.service.StandardReactiveCrudService;
import org.overtime.service.compensate.CompensateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 补偿类型服务接口实现。
 * @author ForteScarlet
 */
@Service
public class CompensateTypeServiceImpl extends StandardReactiveCrudService<CompensateType, Long, CompensateTypeRepository> implements CompensateTypeService {

    @Autowired
    public CompensateTypeServiceImpl(CompensateTypeRepository repository) {
        super(repository);
    }

    @Override
    public Flux<CompensateType> findCompensateTypeByUserId(long userId) {
        return getRepository().findByUserId(userId);
    }

    @Override
    public Mono<CompensateType> findCompensateTypeById(long id) {
        return getRepository().findById(id);
    }
}
