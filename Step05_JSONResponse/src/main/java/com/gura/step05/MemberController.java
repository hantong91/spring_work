package com.gura.step05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.step05.dto.MemberDto;

@Controller
public class MemberController {
	
	@RequestMapping("/member_list")
	@ResponseBody
	public List<MemberDto> getList(){
		MemberDto dto1 = new MemberDto(1,"김구라","노량진");
		MemberDto dto2 = new MemberDto(2,"해골","행신동");
		MemberDto dto3= new MemberDto(3,"원숭이","상도동");
		List<MemberDto> list = new ArrayList<>();
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		return list;
	}
	
	@RequestMapping("/checkid")
	@ResponseBody
	public Map<String,Object> checkid(@RequestParam String inputId){
		//아이디가 존재하는지 여부
		boolean isExist=false;
		if(inputId.equals("gura")){// "gura" 라는 아이디를 있다고 가정
			isExist=true;
			
		}
		Map<String,Object> map=new HashMap<>();
		map.put("isExist", isExist);
		return map;
	}
}
