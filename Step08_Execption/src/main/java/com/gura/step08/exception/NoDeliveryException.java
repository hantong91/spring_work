package com.gura.step08.exception;

import org.springframework.dao.DataAccessException;

/*
 *  Dao 에서 특정 상황이 발생시킬 Custom Exception 클래스 정의하기
 * 
 */
public class NoDeliveryException extends DataAccessException{
		
//	private String message;
	
	
	//생성자
		public NoDeliveryException(String msg){
		
			//생성자의 인자로 전달 받은 문자열을 부모생성자에 전달한다.
			super(msg);
		}
}
