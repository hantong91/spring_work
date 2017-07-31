package test.service;

import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Override
	public void insert() {
		System.out.println("게시글 정보를 저장합니다. [BoardService insert()]");
		
	}

	@Override
	public void select() {
		System.out.println("게시글 목록을 불러 옵니다. [BoardService select()]");
		
	}
}
