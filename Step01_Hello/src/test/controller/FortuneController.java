package test.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

//1. Spring Controller 로 만들겠다는 어노테이션(원래는 extends controller해야되는데 이렇게해도되게해놨음)
@Controller
public class FortuneController {	
	//2. "/fortune.do" 요청을 처리 하겠다는 어노테이션
	@RequestMapping("/fortune")//.do를 써도되고 안써도됨
	public String fortune(HttpServletRequest request){
		String fortuneToday = "동쪽으로 가면 귀인을 만나요";
		request.setAttribute("fortuneToday", fortuneToday);
		/*
		 * 
		 * 
		 *  forward 이동해서 응답할 jsp 페이지의 위치를 문자열로 리턴한다.
		 *  
		 *  
		 *  prefix => "/WEB-INF/views/"
		 *  suffix =>".jsp"
		 *  
		 *  prefix + "fortune" + suffix => "/WEB-INF/views/fortune.jsp"
		 */
		return "fortune";
		/*
		 * 요청경로 : /fortune.do > SpringDispatcherServlet > FortuneController > views/fortune.jsp
		 * do 요청을 받으면 스프링 디스패처가 반응하여 스캔으로 읽어온 정보로 fortunecontroller에게 일을 처리시킴
		 * 
		 * 
		 */
	}
}
