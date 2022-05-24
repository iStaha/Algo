package designpatterns.structual.bridge;

public class Person implements Animal {
	
	MoveLogic moveLogic;
	
	
	public Person(MoveLogic moveLogic) {
		super();
		this.moveLogic = moveLogic;
	}




	@Override
	public void howDoIMove() {
		// TODO Auto-generated method stub
		moveLogic.move();
	}

}
