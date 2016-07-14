package ua.goit.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

//@After("execution( * ua.goit.common.OperationExecutor.*(..))")
@After("execution(public * *(..))")
    public void onExecute (JoinPoint pjp) throws Throwable {
        logger.info("Log Aspect. Method: " + pjp.getSignature().getName() + " is called");

    }
}
