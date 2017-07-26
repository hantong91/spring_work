package test.member.dao;

import java.util.List;

import test.member.dto.MemberDto;

public interface MemberDao {
	public void insert(MemberDto dto);
	public void update(MemberDto dto);
	public void delete(int num);
	public MemberDto getData(int num);
	public List<MemberDto> getList();
}
