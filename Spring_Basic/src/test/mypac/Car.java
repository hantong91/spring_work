package test.mypac;

public class Car {
	//멤퍼 필드
	private String company;//제조사
	private Engine engine; // Engine 객체
	
	
	
	public void setCompany(String company) {
		this.company = company;
	}



	public void setEngine(Engine engine) {
		this.engine = engine;
	}



	//달리는 메소드
	public void drive(){
		System.out.println("자동차의 제조사는 :"+company);
		
		if(engine ==null){
			System.out.println("Engine 객체가 없어서 못달려요!");
			return;
		}
		System.out.println("부릉 부릉! 자동차가 달려요");
	}
}
