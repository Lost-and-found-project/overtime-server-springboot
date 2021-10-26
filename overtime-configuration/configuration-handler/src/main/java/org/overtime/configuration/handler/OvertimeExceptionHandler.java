package org.overtime.configuration.handler;

import lombok.extern.slf4j.Slf4j;
import org.overtime.common.CodeMessageSupport;
import org.overtime.common.HandleableException;
import org.overtime.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;

/**
 * 简单的异常处理。
 *
 * @author ForteScarlet
 */
@Slf4j
@RestControllerAdvice
public class OvertimeExceptionHandler {


    /**
     * 处理异常并作为 {@link Result} 返回.
     * @param exception 异常
     * @return {@link Result}
     */
    @ExceptionHandler(Exception.class)
    public Mono<Result> handler(Exception exception, ServerHttpResponse response) {
        log.error("Exception handler: " + exception.toString(), exception);

        if (exception instanceof CodeMessageSupport codeMessageSupport) {
            Exception realException;
            final var httpResponseStatus = codeMessageSupport.getHttpResponseStatus();
            var resolvedStatus = HttpStatus.resolve(httpResponseStatus);
            if (resolvedStatus != null) {
                response.setStatusCode(resolvedStatus);
            }

            if (exception instanceof HandleableException handleableException) {
                realException = handleableException.getException();
            } else {
                realException = exception;
            }



            return Mono.just(Result.failure(codeMessageSupport.getCode(), codeMessageSupport.getMessage(), realException.toString()));
        }

        // default response status: 500
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        return Mono.just(Result.failure(Result.failure().getCode(), exception.getLocalizedMessage(), exception.toString()));
    }





}
