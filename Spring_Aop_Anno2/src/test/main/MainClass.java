package test.main;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.service.WriteService;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main/init.xml");
		
		WriteService service=context.getBean(WriteService.class);
		
//		service.write();
//		service.writeToFriend();
//		service.writeToTeacher("김구라");
		
		Map<String,Object>map =service.writeToMother();//실행하고 리턴값을 담음 >> hello mama 뜨고 return map
		
		System.out.println("여기는 main() 메소드 입니다.");
		String msg=(String)map.get("msg");
		System.out.println("msdg:"+msg);
	}
	
	
}
