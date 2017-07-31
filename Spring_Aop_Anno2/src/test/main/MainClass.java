package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.service.WriteService;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main/init.xml");
		
		WriteService service=context.getBean(WriteService.class);
		
		service.write();
		service.writeToFriend();
		service.writeToTeacher("김구라");
	}
}
