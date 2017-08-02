package com.gura.step07.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.step07.cafe.dto.CafeDto;
@Repository
public class CafeDaoImpl implements CafeDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(CafeDto dto) {
		session.insert("cafe.insert",dto);
		
	}

	@Override
	public void update(CafeDto dto) {
		session.update("cafe.update",dto);
		
	}

	@Override
	public void delete(int num) {
		session.delete("cafe.delete",num);
		
	}

	@Override
	public List<CafeDto> getList() {
		List<CafeDto> list =session.selectList("cafe.getList");
		
		return list;
	}

	@Override
	public CafeDto getData(int num) {
		// TODO Auto-generated method stub
		return session.selectOne("cafe.getData",num);
	}

	//조회수 증가 시키는 메소드
	@Override
	public void increaseViewCount(int num) {
		session.update("cafe.increaseViewCount",num);
		
		
	}

}
