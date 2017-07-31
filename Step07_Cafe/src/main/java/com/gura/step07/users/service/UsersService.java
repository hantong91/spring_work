package com.gura.step07.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.gura.step07.users.dto.UsersDto;

public interface UsersService {
	public ModelAndView signup(UsersDto dto,HttpServletRequest request);
	public boolean canUseId(String id);
	public ModelAndView signin(UsersDto dto,HttpServletRequest request);
	public ModelAndView updateForm(HttpSession session);
	public void udpate(UsersDto dto);
	public ModelAndView delete(HttpSession session);
}
