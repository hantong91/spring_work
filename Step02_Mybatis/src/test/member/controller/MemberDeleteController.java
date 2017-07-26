package test.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.member.service.MemberService;

@Controller
public class MemberDeleteController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/member/delete")
	public String delete(HttpServletRequest request){
		//삭제할 회원의 번호
		int num =Integer.parseInt(request.getParameter("num"));
		memberService.delete(num);
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("/member/delete2")
			public String delete2(@RequestParam int num){//int로 선언하면 아예 인트타입으로 바꿔서 넣어줌
		memberService.delete(num);
		return "redirect:/member/list.do";
	}
}
