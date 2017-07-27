package test.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import test.member.dto.MemberDto;
import test.member.service.MemberService;

@Controller
public class MemberUpdateController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/member/update")
	public ModelAndView update(@ModelAttribute MemberDto dto){//파라미터에 @RequestParam int num,@RequestParam String name,@RequestParam String addr 해도됨
		/*
		 * @ModelAttribute 어노테이션과 함께 Dto 를 메소드의 인자로
		 * 선언하면 form 전송되는 파라미터가 자동 추출 되고
		 * Dto 에 포장되어서 전달된다.
		 * 단, 전송되는 파라미터명과 Dto 의 필드명은 일치해야한다.
		 * 
		 */
		memberService.update(dto);
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("msg","수정 하였습니다.");
		mView.addObject("url","/member/list.do");
		mView.setViewName("member/alert");
		return mView;
	}
}
