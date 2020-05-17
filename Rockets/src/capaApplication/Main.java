package capaApplication;

import Keyboard.Keyboard;
import capaDomain.Coet;

public class Main {

	public static void main(String[]args) throws Exception{
		startGame(10, 1000);
	}	
	
	public static void startGame(int time, int distance) {
		boolean out = false;
		int star_time = 0;

		Coet c = new Coet("Souvlaki");
		
		System.out.printf("Rocket: "+ c.getName() + "\n");
		System.out.print("Starting competition. Circuit length: 1400. Max time: 20\n");
		
		while(!out && star_time < time) {
			
			System.out.print("Please write the acceleration\n");
			int acelerar = Keyboard.readInt();
			int set;
			double set3;
			
			set = c.calculateSpeedDistance(acelerar, 2);
			set3 = c.calculateFuel();
			
			if(set == 0) {
				star_time += 2;
				
			}else {
				star_time += set;
			}

			System.out.print("Current time: " + star_time + " Acceleration: "  + c.getAcceleration() 
			+ " Speed: " + c.getSpeed() + " Distance: " + c.getDistance() + " Circuit: " + distance 
			) ;
			out = Fuel(distance, c);
			
		}
		
	}
	
	private static boolean Fuel(int distance, Coet coet) {
		if (coet.getFuel() <= 0) {
			System.out.print(" Fuel: 0\n");
		} else {
			System.out.print(" Fuel: " + coet.getFuel()+"\n");
		}
		return false;
	}
	
	
	public static boolean getFuel() {
		
		return false;
		
	}
		
}
