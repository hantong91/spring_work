package test.mypac;

public class MemberDaoImpl implements MemberDao{

	@Override
	public void insert() {
		System.out.println("회원정보를 저장해요");
		
	}

	@Override
	public void update() {
		System.out.println("회원정보를 수정해요");
		
	}

}
