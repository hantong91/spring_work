package com.gura.step05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JSONController {
	
	@RequestMapping(value="/json01",
			produces="application/json;charset=utf-8")
	@ResponseBody
	public String json01(){
		//간단한 json 문자열 응답하기 (jackson 라이브러리 없어도 됨)
		return "{\"num\":999}";// " 문자열을 문자로 인식시키려고 \를 붙임
	}
	
	@RequestMapping("/json02")
	@ResponseBody
	public Map<String,Object> json02(){
		Map<String, Object> map=new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		/*	 
		 * 	1. jackson 라이브러리가 dependency 에 명시 되어있고 
		 *  2. 위 메소드에 @ResponseBody 어노테이션이 붙어있고
		 *  3. servlet-context.xml 에 <mvc:annotation-driven/> 
		 *  이 설정되어있으면
		 *  
		 *  HashMap 객체에 담긴 정보가 아래의 json 형식의 문자열로 
		 *  클라이언트에게 응답된다. 
		 *  
		 *  {"num":1,"name":"김구라","isMan":true}
		 */
		return map;
	}
	
	@RequestMapping(value="/json03")
	@ResponseBody
	public List<String> json03(){
		List<String> list=new ArrayList<>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		/*	
		 *  - jackson 라이브러리가 List 를 아래와 같은 
		 *    json 문서로 출력해준다.
		 * 
		 *  [ "김구라", "해골", "원숭이 ] 
		 */
		return list;
	}
	
	
	@RequestMapping("/json04")
	@ResponseBody
	public List<Map<String, Object>> json04(){
		List<Map<String,Object>> list=
				new ArrayList<Map<String,Object>>();
		Map<String, Object> map1=new HashMap<String,Object>();
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("isMan", true);
		Map<String, Object> map2=new HashMap<String,Object>();
		map2.put("num", 2);
		map2.put("name", "해골");
		map2.put("isMan", false);
		list.add(map1);
		list.add(map2);
		return list;
	}
}
