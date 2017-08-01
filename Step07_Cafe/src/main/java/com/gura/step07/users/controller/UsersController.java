package com.gura.step07.users.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step07.users.dto.UsersDto;
import com.gura.step07.users.service.UsersService;

@Controller
public class UsersController {
	
	//의존 객체
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/users/update")
	public ModelAndView privateUpdate(HttpServletRequest request,
			@ModelAttribute UsersDto dto){
		usersService.update(dto);
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg", "수정하였습니다.");
		String url=request.getContextPath()+"/users/info.do";
		mView.addObject("url", url);
		mView.setViewName("users/alert");
		return mView;
	}
	
	@RequestMapping("/users/updateform")
	public ModelAndView privateUpdateForm(HttpServletRequest request){
		String id=(String)request.getSession().getAttribute("id");
		ModelAndView mView=usersService.detail(id);
		mView.setViewName("users/updateform");
		return mView;
		//이런식으로 setViewName안하고 인자로 전달해도됨 왜냐면 ModelAndVeiw는 수많은 오버로딩이 되어있기때문
	}
	
	@RequestMapping("/users/delete")
	public ModelAndView privateDelete(HttpServletRequest request){
		ModelAndView mView=
				usersService.delete(request.getSession());
		mView.addObject("msg","회원 탈퇴 처리 되었습니다.");
		mView.addObject("url", request.getContextPath());
		mView.setViewName("users/alert");
		return mView;
	}
	
	@RequestMapping("/users/info")
	public ModelAndView privateInfo(HttpServletRequest request){
		//로그인된 아이디를 얻어온다.
		String id=(String)request.getSession().getAttribute("id");
		ModelAndView mView=usersService.detail(id);
		mView.setViewName("users/info");
		return mView;
	}
	
	@RequestMapping("/users/signin_form")
	public String signinForm(){
		
		return "users/signin_form";
	}
	/*
	 *  @ModelAttribute 어노테이션을 이용해서 id, pwd 를 읽어오고
	 *  HttpSession 객체가 필요하면 메소드의 인자로 받을 준비를 해 놓으면
	 *  Spring 에서 알어서 전달해준다. 
	 */
	@RequestMapping("/users/signin")
	public ModelAndView signin(@ModelAttribute UsersDto dto, 
				HttpServletRequest request){
		
		ModelAndView mView=usersService.signin(dto, request);
		
		mView.setViewName("users/alert");
		return mView;
	}
	
	@RequestMapping("/users/signout")
	public ModelAndView signout(HttpSession session){
		//로그 아웃 처리
		session.invalidate();
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg", "로그 아웃 되었습니다.");
		mView.addObject("url", 
				session.getServletContext().getContextPath());
		mView.setViewName("users/alert");
		
		return mView;
	}
	//회원 가입 폼 요청 처리
	@RequestMapping("/users/signup_form")
	public String sinupForm(){
		
		return "users/signup_form";
	}
	// ajax 요청 처리 
	@RequestMapping("/users/checkid")
	@ResponseBody // json 문자열 응답하기 위해 
	public Map<String, Object> checkid(@RequestParam String inputId){
		//서비스를 이용해서 아이디 사용가능 여부를 얻어내서 
		boolean canUse=usersService.canUseId(inputId);
		// jackson 라이브러리를 통해서 json 문자열이 출력되도록 
		// Map 에 담아서 
		Map<String, Object> map=new HashMap<>();
		map.put("canUse", canUse);
		// 리턴해준다. 
		return map;
	}
	//회원 가입 요청 처리 
	@RequestMapping("/users/signup")
	public ModelAndView signup(@ModelAttribute UsersDto dto, 
				HttpServletRequest request){
		ModelAndView mView=usersService.signup(dto, request);
		mView.setViewName("users/alert");
		return mView;
	}
}

















