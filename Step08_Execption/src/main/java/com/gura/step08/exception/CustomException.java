package com.gura.step08.exception;

public class CustomException extends Exception{
	private String message="사용자 정의 Exception";
	//생성자
	public CustomException(String message){
		this.message=message;
	}
	//setter
	public void setmessage(String message){
		this.message =message;
	}
	//getter
	public String getmessage(){
		return message; // getter 를 정의해놓으면 메세지를 출력가능하게됨 
		//없애면 CustomException발생했을때 이 객체를 생성해서 필드를 참조할때 null되서 안뜸
	}
}
