package com.gura.step08.shop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.step08.exception.NoDeliveryException;
import com.gura.step08.shop.dto.ShopDto;





@Repository
public class ShopDaoImpl implements ShopDao{

	@Autowired
	private SqlSession session;

	@Override
	public void signup(String id) {
		session.insert("shop.signup",id);
		
	}

	@Override
	public void deposit(ShopDto dto) {
		session.update("shop.deposit",dto);
		
	}

	@Override
	public void withDraw(ShopDto dto) {
		session.update("shop.withDraw",dto);
		
	}

	@Override
	public void addPoint(ShopDto dto) {
		session.update("shop.addPoint",dto);
		
	}

	@Override
	public void requestDelivery(ShopDto dto) {
		session.insert("shop.requestDelivery",dto);
		
		//특정 상황이 발생했다는 가정하에서 예외 발생시키기
		throw new NoDeliveryException("물건이 없어요!");
	}
	
	

}
