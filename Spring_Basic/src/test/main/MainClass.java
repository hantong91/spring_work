package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;
import test.mypac.WeaponImpl;

public class MainClass {
	public static void main(String[] args) {
		// init.xml 문서를 로딩해서 객체가 생성되고 관리 되도록 한다.
		ApplicationContext context = 
			new ClassPathXmlApplicationContext("test/main/init.xml");
		
		// 관리되는 객체중에서 id 가 myWeapon 인 객체의 참조값을
		//Weapon 인터페이스 type 으로 받는다.
		Weapon weapon = (Weapon)context.getBean("myWeapon");
		
		// 원하는 메소드 호출
		weapon.attack();
		//필요한 객체를 뉴해서 쓰는게 아닌 찾아서 사용
		//아이디 가 myWeapon인걸 꺼내오기 때문에 그 id에 해당하는 클래스를 바꿔주면  main클래스를 손하나도 대지
		// 않고 내용을 바꿀수 있다
		//이렇게 하는 이유는 의존관계를 느슨하게 위함이다.
		//만약 메인 클래스 를 수정하다보면 해당 메소드를 사용하는 클래스와 연관되서 모두 수정해야한다. 
		
		
		//new WeaponImpl().attack();  
		//원래 방식 필요한(의존)객체를 새로만들어서 사용하면 프로젝트가 크다보면 유지보수가 힘들어짐
		//Spring Bean container 
		
	}
}
