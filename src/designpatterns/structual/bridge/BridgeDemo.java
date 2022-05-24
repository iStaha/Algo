package designpatterns.structual.bridge;

public class BridgeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MoveLogic walk = new Walk();

		Animal animalA = new Person(walk);

		MoveLogic fly = new Fly();

		Animal animalB = new Bird(fly);

		animalA.howDoIMove();
		animalB.howDoIMove();

	}

}
