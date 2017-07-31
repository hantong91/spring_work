package test.service;

import org.springframework.stereotype.Service;

@Service
public class WriteServiceImpl implements WriteService{

	@Override
	public void write() {
		System.out.println("글쓰기 작업중...");
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
		
	}

	@Override
	public void writeToFriend() {
		System.out.println("친구에게 글쓰기 작업중...");
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
	}

	@Override
	public void writeToTeacher(String name) {
		System.out.println("선생님게게 글쓰기 작업중...");
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
		
	}

}
