package com.gura.step07.cafe.dao;

import java.util.List;

import com.gura.step07.cafe.dto.CafeDto;

public interface CafeDao {
	public void insert(CafeDto dto);
	public void update(CafeDto dto);
	public void delete(int num);
	public List<CafeDto> getList();
	public CafeDto getData(int num);
	public void increaseViewCount(int num);
}
