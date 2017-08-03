package com.gura.step08.shop.service;

import com.gura.step08.shop.dto.ShopDto;

public interface ShopService {
	public void signup(String id);  //회원가입 처리
	public void deposit(ShopDto dto);  //입금 처리
	public void buy(ShopDto dto);   //상품 구입 처리
	
}
