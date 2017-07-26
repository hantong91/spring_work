package test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//1.
@Controller
public class PersonController {
	@RequestMapping("/person")//2.
	public String person(HttpServletRequest request){
		
		//3. Model 를 Request에 담고
		String personToday = "김구라";
		request.setAttribute("personToday", personToday);
		//4. view 페이지로 forward이동(알아서 해줌)
		return "person";
	}
}
