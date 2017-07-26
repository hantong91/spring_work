package test.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Car;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("test/main2/init.xml");
		
		//Spring Bean Container 에서 car1 이라는 이름의 객체 얻어오기
		Car car1 = (Car)context.getBean("car1");
		Car car2 = (Car)context.getBean("car2");
		
		if(car1==car2){
			System.out.println("car1 과 car2는 참조값이 같아요!");
		}else{
			System.out.println("car1 과 car2는 참조값이 달라요!");
		}
		//참조값이 다르게나옴 >> id마다 객체를 생성하나봄
		
		
		car1.drive();
		
		System.out.println("----------");
		
		car2.drive();
	}
	
}
