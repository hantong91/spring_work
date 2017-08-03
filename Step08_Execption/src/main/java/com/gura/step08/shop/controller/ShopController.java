package com.gura.step08.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.gura.step08.exception.NoDeliveryException;
import com.gura.step08.shop.dto.ShopDto;
import com.gura.step08.shop.service.ShopService;

@Controller
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	@RequestMapping("/shop/signup_form")
	public String signupForm(){
		return "shop/signup_form";
	}
	
	@RequestMapping("/shop/deposit_form")
	public String depositForm(){
		return "shop/deposit_form";
		
	}
	@RequestMapping("/shop/buy_form")
	public String buyForm(){
		return "shop/buy_form";
	}
	
	@RequestMapping("/shop/signup")
	public ModelAndView signup(@RequestParam String id){
		//회원 가입 처리
		shopService.signup(id);
		
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg",id+ "님 가입 되었습니다.");
		mView.setViewName("shop/alert");
		return mView;
	}
	
	
	@RequestMapping("/shop/buy")
	public ModelAndView buy(@ModelAttribute ShopDto dto){
		shopService.buy(dto);
		ModelAndView mView = new ModelAndView();
		mView.addObject("msg",dto.getId()+" 님 물품구입완료!");
		mView.setViewName("shop/alert");
		return mView;
	}
	
	@ExceptionHandler(NoDeliveryException.class)
	public ModelAndView handleNoDeliveryException(NoDeliveryException nde){
		ModelAndView mView=new ModelAndView();
		mView.addObject("exception",nde);
		mView.setViewName("error/data_access");
		return mView;
	}
	
	/*
	 *  @Repository 어노테이션으로 bean 으로 만든 Dao 에서 
	 *  DB 관련 작업을 하다가 발생하는 Exception은 
	 *  DataAccessException이다.
	 */
	
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView handelDataAccessException(DataAccessException dae){
		ModelAndView mView=new ModelAndView();
		mView.addObject("exception",dae);  // 자세히는 모르겠지만 data_access 페이지에서 
											//addObject에 담긴 exception에 el로 exception.message하면  예외내용이 출력됨
											//아마도 DataAccessException에 message라는 필드가 있나봄
		mView.setViewName("error/data_access");
		return mView;
	}
}
