package designpatterns.structual.adapter;

public class AdappterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Movable bugattiVeyron = new BugattiVeyron();
	    MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);
	 
	    System.out.println(bugattiVeyronAdapter.getSpeed());
	    System.out.println(bugattiVeyron.getSpeed());

	}

}
