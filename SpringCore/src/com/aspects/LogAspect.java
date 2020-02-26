package com.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component // means managed by spring, and also component scan
@Aspect
public class LogAspect {

    // pointcut execution of methods in [returnType
    // com.beans.className.methodName(args)]
    // @Before("execution(* com.beans.*.*(..))")
    @Before("@within(org.springframework.stereotype.Controller)")
    public void log(final JoinPoint joinPoint) {
        System.out.println(
            "LogAspect.log():" + joinPoint.getSignature().getName() + " on object: " + joinPoint.getTarget().getClass().getName());
    }

    @Around("execution(* com.beans.*.*(..))")
    public Object calculateExecTime(final ProceedingJoinPoint joinPoint) throws Throwable {

        // before

        StopWatch stopWatch = new StopWatch();
        stopWatch.start(joinPoint.getSignature().getName());

        // invoke the method
        Object result = joinPoint.proceed(joinPoint.getArgs());

        // after code
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        return result;

    }

}
