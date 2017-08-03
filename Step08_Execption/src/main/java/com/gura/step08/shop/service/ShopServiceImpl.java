package com.gura.step08.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gura.step08.shop.dao.ShopDao;
import com.gura.step08.shop.dto.ShopDto;

@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopDao shopDao;
	
	//회원 가입 처리
	@Override
	public void signup(String id) {
		shopDao.signup(id);
		
	}
	//입금 처리
	@Override
	public void deposit(ShopDto dto) {
		shopDao.deposit(dto);
		
	}
	//물품 구입 처리
	@Transactional// 이메소드에서 일어나는 모든 Transaction 관리  : 어느하나라도 실패하면 다시 되돌려줌
	@Override
	public void buy(ShopDto dto) {
		//1. 보너스 포인트를 적립하고
		int point=(int)(dto.getMoney()*0.1); //보너스 포인트를 계산해서
		dto.setPoint(point); //Dto 에 넣어주고		
		shopDao.addPoint(dto); //DB에 반영
		
		//2. 계좌 잔액을 줄이고
		shopDao.withDraw(dto);
		//3. 배송정보를 입력한다.
		shopDao.requestDelivery(dto);
	}

}
