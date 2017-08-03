package com.gura.step08;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step08.exception.CustomException;


@Controller
public class HomeController {
	
	@RequestMapping("/test01")//defaultValue를 지정하면 파라미터에 값이 안들어오는경우 기본값으로 name 에 hello가 들어감
	public ModelAndView test01(@RequestParam(defaultValue="hello") String name) throws Exception{
		ModelAndView mView =new ModelAndView();
		mView.addObject("msg", "정상적으로 처리 되었습니다.");
		mView.setViewName("test/result");
		
		//임의의 test !
		if(name.equals("hello")){
			//예외 객체 생성해서 던지기
			throw new CustomException("파라미터가 전달이 안됐네?");
		}
		return mView;
	}
	
	/*
	 *  CustomException type 의 예외가 발생하면 예외를 처리할 메소드
	 */
	@ExceptionHandler(CustomException.class)// 이 익셉션이 발생하면 실행순서가 일로온다.
	public ModelAndView handleException(CustomException ce){
		//메소드의 인자로 예외 객체가 전달된다.
		
		//에러 페이지로 보내고 싶으면 ModelAndView 객체를 생성해서 리턴
		ModelAndView mView =new ModelAndView();
		//msg 라는 키값으로 예외 메세지를 담는다.
		mView.addObject("exception",ce);
		mView.setViewName("error/custom");
		return mView;
	}
	
	@RequestMapping("/home.do")
	public ModelAndView home(){
		List<String> list=new ArrayList<String>();
		list.add("공지 사항입니다..");
		list.add("어쩌구...");
		list.add("저쩌구...");
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("home");
		return mView;
	}
}














