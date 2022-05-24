package designpatterns.structual.bridge;

public class Bird implements Animal {
	
	MoveLogic moveLogic;
	
	
	public Bird(MoveLogic moveLogic) {
		super();
		this.moveLogic = moveLogic;
	}




	@Override
	public void howDoIMove() {
		// TODO Auto-generated method stub
		moveLogic.move();
	}

}
