package org.overtime.compensate.controller;

import lombok.RequiredArgsConstructor;
import org.overtime.common.domain.CompensateType;
import org.overtime.compensate.api.CompensateTypeApi;
import org.overtime.compensate.service.CompensateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author ForteScarlet
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(CompensateTypeApi.API_REQ_MAPPING)
public class CompensateTypeController implements CompensateTypeApi {
    private final CompensateTypeService compensateTypeService;


    @GetMapping(FIND_BY_USER_ID)
    @Override
    public Flux<CompensateType> findByUserId(@PathVariable Long userId) {
        return compensateTypeService.findCompensateTypeByUserId(userId);
    }
}
