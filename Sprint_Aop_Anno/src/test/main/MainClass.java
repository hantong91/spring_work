package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.service.BoardService;
import test.service.MemberService;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("test/main/init.xml");
		
		
		MemberService memberService=
				context.getBean(MemberService.class);
		memberService.insert();
		memberService.select();
		
		
		BoardService boardService=
				context.getBean(BoardService.class);
		boardService.insert();
		boardService.select();
		
	}
}
