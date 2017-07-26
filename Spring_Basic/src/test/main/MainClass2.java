package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;

public class MainClass2 {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("test/main/init.xml");
		
		Weapon w1 = (Weapon)context.getBean("myWeapon");
		Weapon w2 = (Weapon)context.getBean("myWeapon");
		
		if(w1 == w2){
			System.out.println("w1 과 w2 는 같아요");// 즉 참조값을 가져왔는데 같다면 같은 객체를 만든것임(싱글톤객체)
		}else{
			System.out.println("w1 과 w2는 달라요");
		}
	}
}
