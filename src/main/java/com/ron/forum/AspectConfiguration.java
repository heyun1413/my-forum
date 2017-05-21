package com.ron.forum;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfiguration {

//	@Around("execution(* com.ron.controller.*.*WithVerifyCode(..))")
//	Object ensureVerifyCode(ProceedingJoinPoint joinPoint) {
//		Object[] args = joinPoint.getArgs();
//		if (args[0] instanceof HttpSession) {
//			Object verifyCode = ((HttpSession)args[0]).getAttribute(VerifyCodeController.VERIFY_CODE_KEY);
//			if (verifyCode != null && verifyCode.equals(args[1])) {
//				try {
//					return joinPoint.proceed();
//				} catch (Throwable e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return null;
//	}
}
