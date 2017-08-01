package com.gura.step07;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayController {
	@RequestMapping("/private/play")
	public ModelAndView privatePlay(HttpServletRequest request){
		
		ModelAndView mView=new ModelAndView();
		mView.setViewName("private/play");
		
		return mView;
		
	}
	
}
