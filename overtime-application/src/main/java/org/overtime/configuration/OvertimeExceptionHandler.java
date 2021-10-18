package org.overtime.configuration;

import org.overtime.common.CodeMessageSupport;
import org.overtime.common.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@Component
@RestControllerAdvice
public class OvertimeExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Mono<Result> handler(Exception exception) {
        if (exception instanceof CodeMessageSupport) {
            return Mono.just(Result.failure(((CodeMessageSupport) exception).getCode(), exception.getMessage(), exception.getLocalizedMessage()));
        }

        return Mono.just(Result.failure(exception.getLocalizedMessage()));
    }

}
