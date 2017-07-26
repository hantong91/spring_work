package test.member.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import test.member.dto.MemberDto;

public interface MemberService {
	public void insert(MemberDto dto);
	public void update(MemberDto dto);
	public void delete(int num);
	public ModelAndView getData(int num);
	public ModelAndView getList();
}
