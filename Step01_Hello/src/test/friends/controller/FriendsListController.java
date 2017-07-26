package test.friends.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. component scan 했을때 bean 으로 등록 될 수 있도록
@Controller
public class FriendsListController {
	//2. 요청 맵핑
	@RequestMapping("/friends/list")
	public String friendslist(HttpServletRequest request){
		//3. 비즈니스 로직의 수행결과를 request 에 담고
		
		List<String> friends=new ArrayList<>();
		friends.add("김구라");
		friends.add("해골");
		friends.add("원숭이");
		
		request.setAttribute("friends", friends);
		
		//4. view 페이지로 forward 이동
		return "friends/list";
	}
}
