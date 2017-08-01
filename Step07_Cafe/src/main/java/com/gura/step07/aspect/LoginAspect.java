package com.gura.step07.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class LoginAspect {
	
	@Around("execution(* private*(..))")
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		
		//Aop 가 적용된 메소드에 전달된 인자를 Object[]에 담아온다.
		Object[] args=joinPoint.getArgs();// 적용하는 메소드에 전달되는 인자를 빼옴
		//로그인 여부
		boolean isLogin=false;
		HttpServletRequest request=null;
		for(Object tmp:args){
			//만일 객체가 HttpServletRequest type 객체라면
			if(tmp instanceof HttpServletRequest){
				//원래 type 으로 casting 한다.
				request=(HttpServletRequest)tmp;
				//HttpSession 객체의 참조값을 얻어내서
				HttpSession session =request.getSession();
				//만일 로그인 정보가 존재 한다면
				if(session.getAttribute("id")!=null){
					//로그인 했다는 의미에서 변수에true를 넣어둔다.
					isLogin=true;
				}
			}
		}
		
		//Aop 가 적용된 메소드가 리턴해주는 객체를 Object type 으로 받는다.
		Object obj=joinPoint.proceed();
		//만일 ModelandView type 객체라면
		if(obj instanceof ModelAndView){
			//원래 type으로 casting 해서
			ModelAndView mView =(ModelAndView)obj;
			//조건부로 원하는 작업을 한다.
			if(!isLogin){//로그인을 하지 않으면
				//view 페이지 정보를 수정한다.
				mView.setViewName("/alert");
				mView.addObject("msg","로그인이 필요합니다.");
				//원래 가야할 목적지를 얻어내서
				String url =request.getRequestURI();
				String cPath=request.getContextPath();
				//확인을 눌렀을때 리다일렉트 이동할 url 주소를 구성한다.
				String redirectUrl=cPath+"/users/signin_form.do?url="+url;
				mView.addObject("redirectUrl", redirectUrl);
			}
		}
		
		return obj;
	}
}
