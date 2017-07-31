package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect //Aop
@Component //Bean
public class PrintLogAspect {

	@Around("execution(public void select())")
	public Object printLog(ProceedingJoinPoint joinpoint) throws Throwable{
		System.out.println("비즈니스 로직을 수행하기 직전 입니다.");
		Object obj=joinpoint.proceed();
		System.out.println("비즈니스 로직을 수행했습니다.");
		return obj;
	}
}
