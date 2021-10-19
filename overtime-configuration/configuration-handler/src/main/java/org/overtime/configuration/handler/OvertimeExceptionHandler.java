package org.overtime.configuration.handler;

import lombok.extern.slf4j.Slf4j;
import org.overtime.common.CodeMessageSupport;
import org.overtime.common.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

/**
 * 简单的异常处理。
 *
 * @author ForteScarlet
 */
@Slf4j
@RestControllerAdvice
public class OvertimeExceptionHandler {


    @ExceptionHandler(Exception.class)
    public Mono<Result> handler(Exception exception) {
        log.error("Exception handler.", exception);

        if (exception instanceof CodeMessageSupport) {
            return Mono.just(Result.failure(((CodeMessageSupport) exception).getCode(), exception.getLocalizedMessage(), exception.toString()));
        }

        return Mono.just(Result.failure(exception.getLocalizedMessage()));
    }

}
