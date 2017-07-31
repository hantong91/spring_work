package com.gura.step07.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step07.users.dao.UsersDao;
import com.gura.step07.users.dto.UsersDto;
@Service
public class UsersServiceImpl implements UsersService{

	//의존객체 주입
	@Autowired
	private UsersDao usersDao;
	
	
	//회원 가입 처리
	@Override
	public ModelAndView signup(UsersDto dto,HttpServletRequest request) {
		
		//새로운 회원정보를 저장하고
		usersDao.insert(dto);
		//ModelAndView 객체를 생성해서 정보를 담은 다음
		ModelAndView mView = new ModelAndView();
		mView.addObject("msg",dto.getId()+" 회원님 가입 되었습니다.");
		mView.addObject("url",request.getContextPath());
		//ModelAndView 객체를 리턴해준다.
		return mView;
		
	}
	//사용 가능한 아이디인지 여부 확인
	@Override
	public boolean canUseId(String id) {
		
		//사용가능한 아이디 인지 여부를 리턴받아서
		boolean canUse=usersDao.canUseId(id);
		//리턴해준다.
		return canUse;
	}
	//로그인 처리
	@Override
	public ModelAndView signin(UsersDto dto,HttpServletRequest request) {
		
		//Dao 를 이용해서 유효한 정보인지 확인한다.
		boolean isValid=usersDao.isValid(dto);
		ModelAndView mView =new ModelAndView();
		
		
		//원래 가야할 url 주소
		String url=request.getParameter("url");
		if(isValid){//아이디 비밀번호가 일치한 경우
			//로그인 처리를 해준다.
			request.getSession().setAttribute("id", dto.getId());
			mView.addObject("msg",dto.getId()+" 님 로그인 되었습니다.");
			mView.addObject("url",url);
		}else{//아이디 혹은 비밀번호가 다른경우
			mView.addObject("msg","아이디 혹은 비밀번호가 틀립니다.");
			String location=request.getContextPath()+
					"/users/signin_form.do?url="+url;
			mView.addObject("url",location);
			
		}
		return mView;
	}
	
	//회원 정보 수정 폼 처리
	@Override
	public ModelAndView updateForm(HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}
	//회원 정보 수정 처리
	@Override
	public void udpate(UsersDto dto) {
		// TODO Auto-generated method stub
		
	}
	//회원 정보 삭제 처리
	@Override
	public ModelAndView delete(HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

}
