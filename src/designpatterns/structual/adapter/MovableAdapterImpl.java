package designpatterns.structual.adapter;

public class MovableAdapterImpl implements MovableAdapter {

	private Movable luxuryCars;
	 
	public MovableAdapterImpl(Movable luxuryCars) {
		// TODO Auto-generated constructor stub
		this.luxuryCars = new BugattiVeyron();
		
	}

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		 return convertMPHtoKMPH(luxuryCars.getSpeed());
	}
	
	 private double convertMPHtoKMPH(double mph) {
	        return mph * 1.60934;
	    }

}
