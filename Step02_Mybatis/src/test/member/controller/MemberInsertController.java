package test.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import test.member.dto.MemberDto;
import test.member.service.MemberService;

@Controller
public class MemberInsertController {
	@Autowired
	private MemberService memberService;
	@RequestMapping("/member/insert")
	public String insert(HttpServletRequest request){
		//인자로 전달된 HttpServletRequest 객체로 부터 폼전송된 내용 추출
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		// Dto 객체에 담은 다음
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//서비스 객체를 이용해서 DB에 저장
		memberService.insert(dto);
		//목록 보기로 리다일렉트 이동 되도록
		
		return "redirect:/member/list.do"; //아무것도 안붙이면 forward이동하는데 redirect:붙이면 리다이렉트되고 context는 알아서 찾아내서 적어줌
	}
	
	/*
	 * 	1. 요청 처리후에 redirect 이동하려면 
	 * 리턴 Type 을 String 으로 하고
	 * 리다일렉트 이동할 경로를 리턴해준다.
	 * 
	 * 2.파리미터로 전달되는 값을 Dto Type 으로 포장해서 받고 싶으면
	 * @ModelAttribute 와 함께 메소드의 인자를 선언하면 된다.
	 * 단, 전달되는 파라미터명과 Dto의 필드명이 일치해야 된다.
	 * 
	 */
	
	// 간략하게 하는 방법   단, 폼전송 파라미터명과 dto 필드명이 같아야한다.
	@RequestMapping("/member/insert2")
	public String insert2(@ModelAttribute MemberDto dto){
		memberService.insert(dto);
		return "redirect:/member/list.do";	
	}
}
