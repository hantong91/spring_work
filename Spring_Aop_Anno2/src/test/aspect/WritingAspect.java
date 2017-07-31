package test.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/*
 * 	Aspectj Expression
 * 	(..) 은 이여도 되고 아니여도 되고 라는 의미
 * 	1. execution(public * *(..)) -> 접근 지정자가 public 인 메소드가 point cut
 * 	2. execution(* test.service.*.*(..)) =>test.service 패키지의 모든 메소드 point cut
 * 	3. execution(public void insert*(..))
 * 		 =>접근 지정자는 public 리턴type 은 void 이고 메소드명이
 * 		insert 로 시작하는 모든 메소드가 point cut
 * 	4. execution(* delete*(*))
 * 		=> 메소드 명이 delete 로 시작하고 인자로1 개 전달받는 메소드가 point cut
 * 	5. execution(* delete*(*.*))
 * 	=>메소드 명이 delete 로 시작하고 인자로 2개 전달받는 메소드가 point cut
 * 
 * 
 */

@Aspect
@Component
public class WritingAspect {
	
	@Before("execution (public void write*(*))")
					// 파라미터가 비었기때문에 writeToTeacher(String name)인 메소드는 선택이 안됨
	public void preparePen(){
		//글을 쓰기 전에 펜을 준비하는 작업
		System.out.println("펜을 준비해서 뚜껑을 열어요");
	}
}
