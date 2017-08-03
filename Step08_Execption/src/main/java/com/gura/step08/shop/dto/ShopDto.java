package com.gura.step08.shop.dto;

public class ShopDto {
	private String id;
	private int money;
	private int point;
	private String addr;
	
	public ShopDto(){}

	public ShopDto(String id, int money, int point, String addr) {
		super();
		this.id = id;
		this.money = money;
		this.point = point;
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
