package test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homecontroller {
	@RequestMapping("/home")
	public String home(HttpServletRequest request){
		
		List<String> list = new ArrayList<>();
		list.add("오늘은...");
		list.add("어쩌구...");
		list.add("저쩌구...");
		request.setAttribute("list", list);
		
		
		
		return "home";
	}
}
