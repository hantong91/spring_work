package test.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;
//1. component scan 되었을때 Spring Bean Container 에 관리 되도록 service(비즈니스로직을 담당하는) 클래스를 Service로 어노테이션
@Service
public class MemberServiceImpl implements MemberService{

	//2. 의존 객체가 주입 될 수 있도록
	@Autowired
	private MemberDao memberDao;
	
	
	@Override
	public void insert(MemberDto dto) {
		memberDao.insert(dto);
		
	}

	@Override
	public void update(MemberDto dto) {
		memberDao.update(dto);
		
	}

	@Override
	public void delete(int num) {
		
		memberDao.delete(num);
	}

	@Override
	public ModelAndView getData(int num) {
		
		//회원의 번호를 이용해서 회원정보를 얻어온다.
		MemberDto dto = memberDao.getData(num);
		//ModelAndView 객체를 생성해서
		ModelAndView mView = new ModelAndView();
		//request.setAtttribute() 대신 .addObject()해서
		//회원 정보를 담아서
		mView.addObject("dto",dto);
		//리턴해준다.		
		return mView;
	}

	//회원 목록을 얻어오는 비즈니스 로직을 처리하는 서비스의 메소드
	@Override
	public ModelAndView getList() {
		//주입 받은 Dao 객체를 이용해서 회원 목록을 얻어온다.
		List<MemberDto> list=memberDao.getList();
		//ModelAndView 객체를 생성해서
		ModelAndView mView= new ModelAndView();     //파라미터에 HttpServletRequest request할필요없이
													//모델엔 뷰객체생성해서 request에 담는거처럼 addObject하면됨
		//request 에 담는 대신 ModelAndView 객체에 담고
		mView.addObject("list",list);
		//리턴해준다.
		return mView;
	}

}
