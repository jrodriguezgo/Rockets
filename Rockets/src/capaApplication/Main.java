package capaApplication;

import Keyboard.Keyboard;
import capaDomain.Coet;

public class Main {

	public static void main(String[]args) throws Exception{
		startGame(20, 1400);
	}	
	
	public static void startGame(int time, int distance) {
		boolean out = false;
		int star_time = 0;

		Coet c = new Coet("Souvlaki");
		
		System.out.printf("Rocket: "+ c.getName() + "\n");
		System.out.print("Starting competition. Circuit length: " + distance +". Max time: " + time + "\n");
		
		while(!out && star_time < time) {
			
			System.out.print("Please write the acceleration\n");
			int acelerar = Keyboard.readInt();
			int set;
			
			set = c.calculateSpeedDistance(acelerar, 2);
			set = (int) c.calculateFuel();
			
			if(set == 0) {
				star_time += 2;
				
			}else {
				star_time += set;
			}

			System.out.print("Current time: " + star_time + " Acceleration: "  + c.getAcceleration() 
			+ " Speed: " + c.getSpeed() + " Distance: " + c.getDistance() + " Circuit: " + distance 
			);
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
	
		
}
