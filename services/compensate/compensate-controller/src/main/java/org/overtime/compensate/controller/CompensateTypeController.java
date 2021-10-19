package org.overtime.compensate.controller;

import lombok.RequiredArgsConstructor;
import org.overtime.common.domain.CompensateType;
import org.overtime.compensate.service.CompensateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author ForteScarlet
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompensateTypeController {
    private final CompensateTypeService compensateTypeService;

    @GetMapping("/comp/type/user/{userId}")
    public Flux<CompensateType> findCompensateTypeByUserId(@PathVariable("userId") Long userId) {
        return compensateTypeService.findCompensateTypeByUserId(userId);
    }

}
