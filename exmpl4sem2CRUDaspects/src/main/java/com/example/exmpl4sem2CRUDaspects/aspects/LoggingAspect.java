package com.example.exmpl4sem2CRUDaspects.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returning")
    public void log(JoinPoint joinPoint, Object returning) {
        System.out.println("Method executed " + returning + joinPoint.getSignature().getName() + returning.getClass() );
    }

}

