package org.overtime.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.overtime.common.Result;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@Aspect
@Component
@ConditionalOnClass(name = {"org.springframework.web.reactive.result.method.annotation.ResponseBodyResultHandler"})
@Configuration
public class OvertimeResultProcessor {

    @Around(value = "execution(* org.springframework.web.reactive.result.method.annotation.ResponseBodyResultHandler.handleResult(..)) && args(exchange, result)", argNames = "point,exchange,result")
    public Object handleResult(ProceedingJoinPoint point, ServerWebExchange exchange, HandlerResult result) throws Throwable {
        ResolvableType returnType = result.getReturnType();
        Object response = result.getReturnValue();

        
        if (response != null) {
            if (returnType.isAssignableFrom(Mono.class)) {
                response = ((Mono<?>) response).map(v -> v instanceof Result ? v : Result.success(v));
            } else if (returnType.isAssignableFrom(Flux.class)) {
                response = ((Flux<?>) response).map(v -> v instanceof Result ? v : Result.success(v));
            }
        }

        return point.proceed(new Object[]{
                exchange,
                new HandlerResult(result.getHandler(), response, result.getReturnTypeSource())
        });

        // final Mono responseMono = ((Mono) result.getReturnValue())
        //         .map(responseValue -> responseValue instanceof ResponseInfo ? responseValue : ResponseInfo.ok(responseValue));
        // return point.proceed(Arrays.asList(
        //         exchange,
        //         new HandlerResult(result.getHandler(), responseMono, result.getReturnTypeSource())
        // ).toArray());
    }
}
