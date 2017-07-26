package test.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import test.member.service.MemberService;

//1. component scan 이 되었을때 스프링 컨테이너에서 관리 되도록
@Controller
public class MemberListController {
	//3. 의존 객체를 주입 받을 수 있도록 (Dependency Injection)
	@Autowired
	private MemberService memberService;
	
	
	
	//2. 요청이 맵핑될수 있도록
	@RequestMapping("/member/list")
	public ModelAndView list(){//Model And View => Data And View page infomation
								//Data를 Model이라고하는데 원래 하던 방식은 data를 request에 담아서 viewpage에 보내는 식이였지만
									// 이렇게 하면 알아서 request에 date를 담고 view페이지 정보도 같이담음   forward이동도 해줌
		
		
		// MemberService service = new MemberServiceImpl();
		// service.getList(); 하면 의존관계가 강해져서 야근하고 퇴근못함 좆됨
		
		
		//Datea 가 담겨진 ModelAndView 객체를 리턴 받고 (어떤 서비스를 통해서 비즈니스로직을 처리하는지)
		ModelAndView mView = memberService.getList();
		
		//forward 이동할 view 페이지 정보를 넣어주고
		mView.setViewName("member/list");
		
		/*
		 * 
		 *  ModelAndView 객체를 리턴해주면 
		 *  객체에 담긴 Data 가 request에 자동으로 담기고
		 *  view 페이지로 알아서 forward 이동된다.
		 */
		return mView;
	}
}
