package com.gura.step07.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step07.cafe.dao.CafeCommentDao;
import com.gura.step07.cafe.dao.CafeDao;
import com.gura.step07.cafe.dto.CafeCommentDto;
import com.gura.step07.cafe.dto.CafeDto;

@Service
public class CafeServiceImpl implements CafeService{

	/*
	 * 
	 *  하나의 서비스에서 여러개의 Dao 를 의존할수 도 있다.
	 */
	
	@Autowired
	private CafeDao cafeDao;
	@Autowired
	private CafeCommentDao commentDao;
	
	@Override
	public void insert(CafeDto dto) {
		cafeDao.insert(dto);
		
	}

	@Override
	public void delete(int num) {
		cafeDao.delete(num);
		
	}

	@Override
	public void update(CafeDto dto) {
		cafeDao.update(dto);
		
	}

	@Override
	public ModelAndView list() {
		// Dao 를 이용해서 글목록을 얻어온다.
		List<CafeDto> list = cafeDao.getList();
		//ModelAndView 객체를 생성해서
		ModelAndView mView=new ModelAndView();
		//request 영역에 담는 대신 ModelAndView 객체에 담고
		mView.addObject("list",list);
		//ModelAndView 객체를 리턴해준다.
		return mView;
	}

	@Override
	public ModelAndView detail(int num) {
		//인자로 전달되는 num 에 해당하는 글정보르 얻어온다.
		CafeDto dto =cafeDao.getData(num);
		//덧글 목록을 얻어온다.
		List<CafeCommentDto> commentList = commentDao.getList(num);
		//ModelAndView 객체를 생성해서 Model을 담고
		ModelAndView mView =new ModelAndView();
		mView.addObject("dto",dto);
		mView.addObject("commentList",commentList);
		
		return mView;
	}

	//새덧글을 입력하는 비즈니스 로직을 처리할 서비스 메소드
	@Override
	public void commentInsert(CafeCommentDto dto) {
		//1. 저장할 덧글 번호를 미리 읽어온다.
		int seq=commentDao.getSequence();
		dto.setNum(seq);//글번호로 사용한다.
		//2. 원글의 덧글인지 덧글의 덧글인지 판정해서 다른 처리를 해준다.
		int comment_group = dto.getComment_group();
		if(comment_group == 0){//0 이면 원글의 덧글
			//원글의 덧글이면 그룹번호를 저장할 덧글 번호로 지정한다.
			dto.setComment_group(seq);			
		}
		//3. Dao 를 이용해서 DB에 저장
		commentDao.insert(dto);
		
	}
	//조회수 증가 시키는 기능
	@Override
	public void increaseViewCount(int num) {
		cafeDao.increaseViewCount(num);
		
	}

}
