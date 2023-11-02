package top.imono.jk.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TestAspect  {

    @Around("execution(* top.imono.jk.controller..*.*(..))")
    public Object handleRemove(ProceedingJoinPoint point) throws Throwable {
        log.debug(point.toString());
        return point.proceed();
    }

}
