package org.overtime.configuration.handler;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.overtime.common.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;
import org.springframework.web.reactive.result.method.InvocableHandlerMethod;
import org.springframework.web.reactive.result.method.annotation.ResponseBodyResultHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 对 标记了 {@link org.springframework.web.bind.annotation.RestController}
 *
 *
 * TODO 考虑是否真的有必要
 *
 * @author ForteScarlet
 */
@Slf4j
public class OvertimeResponseBodyResultHandler extends ResponseBodyResultHandler {


    private static Mono<Result> mr() {
        return null;
    }

    private static Flux<Result> fr() {
        return null;
    }

    private static Result r() {
        return null;
    }

    private static final MethodParameter MR;
    private static final MethodParameter FR;
    private static final MethodParameter R;

    static {
        Class<OvertimeResponseBodyResultHandler> clazz = OvertimeResponseBodyResultHandler.class;
        try {
            Method mr = clazz.getDeclaredMethod("mr");
            Method fr = clazz.getDeclaredMethod("fr");
            Method r = clazz.getDeclaredMethod("r");

            MR = new MethodParameter(mr, -1);
            FR = new MethodParameter(fr, -1);
            R = new MethodParameter(r, -1);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }

    OvertimeResponseBodyResultHandler(List<HttpMessageWriter<?>> writers, RequestedContentTypeResolver resolver) {
        super(writers, resolver);
        // default handler is 100.
        setOrder(99);
    }

    @Override
    public @NotNull Mono<Void> handleResult(@NotNull ServerWebExchange exchange, HandlerResult result) {
        Object handler = result.getHandler();
        MethodParameter actualMethodParameter;

        if (handler instanceof InvocableHandlerMethod invocableHandlerMethod) {
            if (invocableHandlerMethod.getBeanType().getAnnotation(IgnoreHandlerResult.class) != null) {
                return super.handleResult(exchange, result);
            }
            if (invocableHandlerMethod.getMethod().getAnnotation(IgnoreHandlerResult.class) != null) {
                return super.handleResult(exchange, result);
            }
            if (invocableHandlerMethod.getMethod().getAnnotation(ExceptionHandler.class) != null) {
                return super.handleResult(exchange, result);
            }
        }

        Object body = result.getReturnValue();

        if (body instanceof Mono<?> mono) {
            body = toResult(mono);
            actualMethodParameter = MR;
        } else if (body instanceof Flux<?> flux) {
            body = toResult(flux);
            actualMethodParameter = MR;
        } else {
            body = toResult(body);
            actualMethodParameter = R;
        }


        return writeBody(body, actualMethodParameter, exchange);
    }

    private static Mono<Result> toResult(Mono<?> mono) {
        return mono.map(Result.asSuccess()).defaultIfEmpty(Result.success());
    }

    private static Mono<Result> toResult(Flux<?> flux) {
        return toResult(flux.collectList());
    }

    private static Result toResult(Object obj) {
        return Result.success(obj);
    }


}
