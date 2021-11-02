package org.overtime.compensate.service.impl;

import org.overtime.common.domain.CompensateType;
import org.overtime.common.service.StandardR2dbcService;
import org.overtime.compensate.repository.CompensateTypeRepository;
import org.overtime.compensate.service.CompensateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 补偿类型服务接口实现。
 *
 * @author ForteScarlet
 */
@Service
public class CompensateTypeServiceImpl extends StandardR2dbcService<CompensateType, Long, CompensateTypeRepository> implements CompensateTypeService {

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
