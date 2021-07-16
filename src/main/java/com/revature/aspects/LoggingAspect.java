package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Before(value="log()", argNames="jp")
	public void setLogger(JoinPoint jp) {
		this.logger.info("Executing " + jp.getSignature().getName());
	}
	
	@Pointcut("execution(* com.revature.repo.*.*(..))")
	public void log() {}
}
