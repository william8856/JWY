package com.jwy.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component  // 현재 클래스가 스프링의 빈으로 인식되도록
@Aspect  // AOP기능을 하는 클래스임을 선언
public class SampleAOPAdvice {
	private static final Logger logger = LoggerFactory.getLogger(SampleAOPAdvice.class);
	
	@Before("execution(* com.jwy.service.MessageService*.*(..))")  // pointcut을 지정.
	// com.jwy.service.MessageService로 시작하는 모든 클래스의 모든 메서드를 지정
	public void startLog(JoinPoint jp) {
		logger.info("------------------------------------");
		logger.info("------------------------------------");
		logger.info(Arrays.toString(jp.getArgs()));
	}
	
	@Around("execution(* com.jwy.service.MassageService*.*(..))")
	// Around : 메서드의 실행 앞(Before) + 뒤(After)를 감싸 특정 기능을 수행하도록 하는
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		logger.info(Arrays.toString(pjp.getArgs()));
		
		Object result = pjp.proceed();  // 실제 target이 가지고 있는 메서드를 호출
		
		long endTime = System.currentTimeMillis();
		logger.info(pjp.getSignature().getName() + " : " + (endTime - startTime));
		logger.info("===========================================================");
		
		return result;
	}
}
