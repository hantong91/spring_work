package com.gura.step08.shop.dao;

import com.gura.step08.shop.dto.ShopDto;

public interface ShopDao {
	public void signup(String id); //회원가입
	public void deposit(ShopDto dto); //입금
	public void withDraw(ShopDto dto); //출금
	public void addPoint(ShopDto dto); //포인트 적립
	public void requestDelivery(ShopDto dto); //배송요청
}
