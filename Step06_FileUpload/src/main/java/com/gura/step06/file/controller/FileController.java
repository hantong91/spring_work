package com.gura.step06.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step06.file.dto.FileDto;
import com.gura.step06.file.service.FileService;

@Controller
public class FileController {
	
	//의존객체
	@Autowired
	private FileService fileService;
	
	@RequestMapping("/file/insertform")
	public String insertform(){
		
		return "file/insertform";
	}
	
	@RequestMapping("/file/insert")
	public String insert(HttpServletRequest request, 
					@ModelAttribute FileDto dto){
		//FileService 객체를 통해서 업로드 처리를 한다.
		fileService.insert(request, dto);
		
		//파일 목록 보기로 리다일렉트 이동 시킨다. 
		return "redirect:/file/list.do";
	}
	
	@RequestMapping("/file/list")
	public ModelAndView list(){
		
		ModelAndView mView=fileService.list();
		mView.setViewName("file/list");
		
		return mView;
	}
	
	@RequestMapping("/file/download")
	public ModelAndView download(@RequestParam int num){
		//다운로드할 파일의 정보를 ModelAndView 객체에 담아서 리턴 받는다.
		ModelAndView mView=fileService.getData(num);
		
		//파일을 다운로드 시켜줄 view 객체의 이름을 지정하고
		mView.setViewName("fileDownView");
		
		//리턴해준다. 
		return mView;
	}
	
	@RequestMapping("/file/delete")
	public String delete(HttpServletRequest request,@RequestParam int num){//request선언하면 알아서 전달이됨
		//FileService 객체를 이용해서 파일 삭제 처리
		fileService.delete(request,num);
		return "redirect:/file/list.do";
	}
}




















