package test.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.member.dto.MemberDto;
//1. component scan 되었을때 Spring Bean Container 에 등록 되도록 (dao같은 역할하는 녀석들은 Repository로 어노테이션함)
@Repository
public class MemberDaoImpl implements MemberDao{

	//2. 의존 객체를 주입 받을수 있도록
	@Autowired
	private SqlSession session;
	
	
	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert",dto);
		
	}

	@Override
	public void update(MemberDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		session.delete("member.delete",num);
		
	}

	@Override
	public MemberDto getData(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDto> getList() {
		//주입 받은 SqlSession 객체를 이용해서 회원목록을 select한다.
		List<MemberDto> list =session.selectList("member.getList");
		// session 객체를 Spring 이 알아서 관리 하기 때문에
		// .close() 하지 않는다.
		
		return list;
	}

}
