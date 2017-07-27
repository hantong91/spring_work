package com.gura.step04.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownController {
	
	
	@RequestMapping("/file/download")
	public ModelAndView download(@RequestParam int num){
		
		
		ModelAndView mView=new ModelAndView();
		mView.addObject("info","kimgura.jpg");
		//@Component("fileDownView") 가 붙은 view 로 응닫하기
		mView.setViewName("fileDownView");
		
		return mView;
	}
}
