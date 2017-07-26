package test.main4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.MemberDao;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main4/init.xml");
		/*
		 * getBean(얻어낼 객체의 class type)
		 * 
		 * 단, Spring 이 관리하는 컨테이너에 해당객체가 오직 1개일때
		 * 
		 */
		MemberDao dao = (MemberDao)context.getBean(MemberDao.class);
		dao.insert();
		dao.update();
	}
}
