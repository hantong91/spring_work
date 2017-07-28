package com.gura.step06.file.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.step06.file.dto.FileDto;

// FileServiceImpl 클래스가 구현할 인터페이스
public interface FileService {
	public void insert(HttpServletRequest request, FileDto dto);
	public ModelAndView list();
	public void delete(HttpServletRequest request, int num);
	public ModelAndView getData(int num);	
}










