package domain;

import Keyboard.Keyboard;

public class Tank {
	
	private static double fuelQuantity;
	//private static int speed;
	
	public Tank(double fuel) throws Exception {
		if(fuel <= 0) {
			throw new Exception("Incorrect fuel capacity");
		}
		//speed = 0;
		fuelQuantity = fuel;
	}
	
	public static double getfuelQuantity() {
		return fuelQuantity;
	}
	
	public void setfuelQuantity(double quantity) {
		fuelQuantity = quantity;
	}

	public static int addFuel() {	/*ASK FOR FUEL CAPACITY*/
		System.out.print("How much fuel does the rocket have? ");
		int fuelQuantity = Keyboard.readInt();
		return fuelQuantity;
		
	}
	
	public double calculateFuel(Rocket rocket) {	//Fuel
		rocket.getFuel();
		double currentFuel = Tank.getfuelQuantity() - rocket.getSpeed();
		rocket.getFuel().setfuelQuantity(currentFuel);
		return currentFuel;
	}
}
