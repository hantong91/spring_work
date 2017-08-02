package com.gura.step07.cafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step07.cafe.dto.CafeCommentDto;
import com.gura.step07.cafe.dto.CafeDto;
import com.gura.step07.cafe.service.CafeService;

@Controller
public class CafeController {

		@Autowired
		private CafeService cafeService;
		
		
		
		@RequestMapping("/cafe/delete")
		public String idCheckDelete(HttpSession session,@RequestParam int num){
			cafeService.delete(num);
			return "redirect:/cafe/list.do";
		}
		
		
		@RequestMapping("/cafe/update")
		public String idCheckUpdate(HttpSession session,@ModelAttribute CafeDto dto){
			// session에서 writer 얻는 거 의미없음 왜냐면 cafemapper에서 id =update 항목에
			// writer에 대한 수정이 아예없기때문 그러니까 아래는 사용하지도않는 정보를 긁어다가 사용한거임
			// 따라서 파라미터에 HttpSession을 받을 필요도 없게됨 >> 이거는 idCheck Aop 일때 사용하므로 session사용하는건 맞음
			
			//글 작성자는 세션에서 얻어내어서
			String writer=(String)session.getAttribute("id");
			//dto에 담은다음
			dto.setWriter(writer);
			
			
			//서비스 객체를 이용해서 수정 반영한다.
			cafeService.update(dto);
			return "redirect:/cafe/list.do";
		}
		
		@RequestMapping("/cafe/updateform")
		public ModelAndView privateUpdateform(HttpServletRequest request, @RequestParam int num){
			ModelAndView mView=cafeService.detail(num);
			mView.setViewName("cafe/updateform");
			return mView;
		}
		
		@RequestMapping("/cafe/comment_insert")
		public String commentInsert(@ModelAttribute CafeCommentDto dto){
			//@ModelAttribute 어노테이션을 이용해서 덧글 정보를 얻어온다.
			
			//서비스 객체를 이용해서 덧글이 저장될수 있도록 한다.
			cafeService.commentInsert(dto);
			//원글의 글번호
			int num =dto.getRef_group();
			
			//리다일렉트 응답할때 사용한다.
			return "redirect:/cafe/detail.do?num="+num;
		}
		
		
		@RequestMapping("/cafe/detail")
		public ModelAndView detail(@RequestParam int num,HttpSession session){
			ModelAndView mView =cafeService.detail(num);
			mView.setViewName("cafe/detail");
			String id = (String)session.getAttribute("id");
			//로그인 했는지 여부도 ModelAndView 객체에 담아서
			if(id==null){
				mView.addObject("isLogin", false);
				
			}else{
				mView.addObject("isLogin",true);
				
			}
			//조회수 증가시키기
			cafeService.increaseViewCount(num);
			//리턴해준다.
			return mView;
		}
		
		
		@RequestMapping("/cafe/insert")
		public String idCheckInsert(HttpSession session, @ModelAttribute CafeDto dto){
							// writer 는 session에          title, content는 dto에 들어있음
			//글 작성자를 읽어온다.
			String writer =(String)session.getAttribute("id");
			if(writer!=null){// aop안쓰고할려면 이런식으로 걸러냄
			}else{				
			}
			//CafeDto 에 넣어준다.
			dto.setWriter(writer);
			//Service 객체를 이용해서 저장
			cafeService.insert(dto);
			
			
			return "redirect:/cafe/list.do";
		}
		
		@RequestMapping("/cafe/insertform")
		public ModelAndView privateInsertForm(HttpServletRequest request){
							//private를 넣어서 로그인을 했는지 안했는지 aop로 걸러냄
							//파라미터에 request를 전달인자로 해놓으면 aop에서 Object[] args = joinPoint.getArgs(); 로 얻어냄
			ModelAndView mView =new ModelAndView();
			mView.setViewName("cafe/insertform");
			return mView;
			
		}
		
		
		@RequestMapping("/cafe/list")
		public ModelAndView list(){
			//서비스를 이용해서 글목록이 담긴 ModelAndView 객체를 리턴받는다.
			ModelAndView mView=cafeService.list();
			//view 페이지 설정하고
			mView.setViewName("cafe/list");
			//ModelAdnView 객체를 리턴해준다.
			return mView;
		}
}
