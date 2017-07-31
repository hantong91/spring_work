package com.gura.step07.users.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.step07.users.dto.UsersDto;
@Repository
public class UsersDaoImpl implements UsersDao{
	@Autowired
	private SqlSession session;
	
//	@Override
//	public List<UsersDto> getList() {
//		List<UsersDto> list = session.selectList("users.getList");
//		
//		return list;
//	}

	@Override
	public UsersDto getData(String id) {
		UsersDto dto = session.selectOne("users.getData",id);
		return null;
	}

	@Override
	public void delete(String id) {
		session.delete("users.delete",id);
		
	}

	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert",dto);
		
	}

	@Override
	public void update(UsersDto dto) {
		session.update("users.update",dto);
		
	}

	@Override
	public boolean isValid(UsersDto dto) {
		UsersDto resultDto=session.selectOne("users.isValid",dto);
		if(resultDto==null){//id 혹은 비밀번호가 틀린경우
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public boolean canUseId(String id) {
		String result = session.selectOne("users.canExistId",id);
		if(result==null){
			return true;
		}else{
			
		}
		return false;
	}

}
