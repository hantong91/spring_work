package test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;


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
 * 	5. execution(* delete*(*,*))
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
	
	@After("execution(public void write*())")
	public void endPen(){
		System.out.println("펜의 뚜껑을 닫고 정리를 해요");
	}
	
	
	/*
	 * Around Aop 는 JoinPoint 를 지원해 준다.
	 * 
	 */
	@Around("execution(public void *ToTeacher(*))")//before after 모르겠으면 어라운드하면됨
	public void aroundPen(ProceedingJoinPoint joinPoint) throws Throwable{
		//Aop 가 적용된 메소드에 전달된 인자를 배열로 얻어내기
		Object[] args=joinPoint.getArgs(); //뭐들었는지 조사하는거
		//배열에 있는 객체를 반복문 돌면서 불러온다.
		for(Object tmp:args){
			//만일 객체가 String type 이라면
			if(tmp instanceof String){
				String name=(String)tmp;
				System.out.println("메소드에 전달된 String:"+name);
			}
		}
		
		//proceed 이전에 적는건 before와 같음
		
		//Aop 가 적용된 메소드 수행하고 + 리턴되는 데이터가 있으면(있다면) 받기
		joinPoint.proceed();
		
		//proceed 이후는 after와 같음
		
		//여기는 메소드 수행 이후에 할 작업을 하면 된다.
		System.out.println("Aop 적용 이후에 작업을 해요~");
	}
	
	@Around("execution(public java.util.Map *ToMother())")
	public Object aroundMother(ProceedingJoinPoint joinPoint) throws Throwable{
		//Aop 가 적용된 메소드가 리턴해주는 참조값을 Object type 으로 받는다.
		Object obj =joinPoint.proceed();
				//여기부터 after로 해도되지않냐 싶지만 after로 하면 joinpoint를 제공못받기때문에 리턴값도 못받음
		
		//리턴된 객체가Map type 이라면
		if(obj instanceof Map){
			//원래 type으로 casting 해서
			Map<String,Object> map = (Map)obj;
			//Map 에 저장된 데이터 읽어와 보기
			String msg=(String)map.get("msg");
			System.out.println("msg:"+msg);
			//Map 에 저장된 데이터 수정하기
			map.put("msg", "안녕 엄마~");
		
		}
		return obj;// obj에는 proceed로 부터 적용된메소드의 리턴참조값이 담겨있다. 
					//그 obj를 map으로 캐스팅 했을뿐이고 그걸 수정하고 return obj한것 
					//근데 뭣하러 return 하는지는  모르겠고 안하면 오류남
					
	}
}
