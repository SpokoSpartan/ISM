package io.swagger.logic.aspects;

import io.swagger.logic.service.StatisticService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StatisticAspect {

    private final StatisticService statisticService;

    public StatisticAspect(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Around("execution(* io.swagger.api.impl.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        statisticService.saveInvocation(getClassName(joinPoint), getMethodName(joinPoint), executionTime);

        return proceed;
    }

    private String getClassName(ProceedingJoinPoint joinPoint) {
        return joinPoint.getTarget().getClass().getName();
    }

    private String getMethodName(ProceedingJoinPoint joinPoint) {
        return ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
    }

}
