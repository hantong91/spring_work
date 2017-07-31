package test.service;

public class MemberServiceImpl implements MemberService{

	@Override
	public void insert() {
		System.out.println("회원 정보를 저장합니다. [MemberService insert()]");
		
	}

	@Override
	public void select() {
		System.out.println("회원목록을 불러 옵니다. [MemberService select()]");
		
	}

}
