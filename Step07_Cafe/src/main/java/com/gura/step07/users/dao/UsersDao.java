package com.gura.step07.users.dao;

import java.util.List;

import com.gura.step07.users.dto.UsersDto;

public interface UsersDao {
	//public List<UsersDto> getList();
	public UsersDto getData(String id);
	public void delete(String id);
	public void insert(UsersDto dto);
	public void update(UsersDto dto);
	public boolean isValid(UsersDto dto);//아이디가 유효한지(로그인가능한 아이디인지
	public boolean canUseId(String id);//중복인지(생성할때 중복인지
}
