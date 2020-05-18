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
		while(!out && star_time < time && c.getFuel() > 0) {
			System.out.print("Please write the acceleration\n");
			int acelerar = Keyboard.readInt();
			int set;
			int current_distance = 0;
			set = c.calculateSpeedDistance(acelerar, 2);
			set = (int) c.calculateFuel();		
			if(set == 0) {
				star_time += 2;
				
			}else {
				star_time += set;
			}
			System.out.print("Current time: " + star_time + " Acceleration: "  + c.getAcceleration() 
			+ " Speed: " + c.getSpeed() + " Distance: " + c.getDistance() + " Circuit: " + distance);
			
			current_distance += c.getDistance();
			out = Fuel(distance, c, current_distance);
			
		}
		Score(out, star_time, c);		
	}
	
	private static boolean Fuel(int distance, Coet coet, int current_distance) {	
		if (coet.getFuel() <= 0) {
			System.out.print(" Fuel: 0\n");
		} else {
			System.out.print(" Fuel: " + coet.getFuel() +"\n");
			
		}
		if(current_distance >= distance && coet.getFuel() >= 0) {
			return true;
		}
		return false;
	}
	
	public static void Score(boolean end, int time, Coet coet) {
		if(end) {
			System.out.print("And the winner is: " + coet.getName() + " with a time of " +time);
		}else {
			System.out.print("There is no winner, sorry!");
		}
	}	
}
