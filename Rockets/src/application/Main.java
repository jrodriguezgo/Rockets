package application;

import Keyboard.Keyboard;
import domain.Race;
import domain.Rocket;

public class Main {

	public static void main(String[]args) throws Exception{
		Race race = new Race(20, 1400);
	}	
	
	//ha d'estar a Race
	public static void startGame(int time, int distance) throws Exception { /*START A NEW GAME*/
		boolean out = false;
		int startTime = 0, currentDistance = 0;
		Rocket rocket = createRocket();	
		System.out.print("------------------------------------\n");
		System.out.printf("Rocket: "+ rocket.getName() + "\n");
		System.out.print("Starting competition. Circuit length: " + distance +". Max time: " + time + "\n");
		while(!out && startTime < time && rocket.getFuel() > 0) {		
			startTime = calculateRace(rocket, time, startTime, distance, currentDistance);
			currentDistance = rocket.getDistance();
			out = fuelResults(distance, rocket, currentDistance);
		}
		finalScore(out, startTime, rocket);		
	}
	
	
	private static int addThrusters() {	/*ASK FOR THRUSTERS QUANTITY*/
		System.out.print("How many propellers does the rocket have? ");
		int thrustersQuantity = Keyboard.readInt();
		return thrustersQuantity;
	}
	
	private static int addFuel() {	/*ASK FOR FUEL CAPACITY*/
		System.out.print("How much fuel does the rocket have? ");
		int fuelQuantity = Keyboard.readInt();
		return fuelQuantity;
	}
	
	private static Rocket createRocket() throws Exception {	/*CREATE THE ROCKET*/
		int thrustersQuantity = addThrusters();
		int fuelQuantity = addFuel();
		Rocket rocket = new Rocket("SOUVLAKI", thrustersQuantity, fuelQuantity);
		for(int i = 0; i < thrustersQuantity; i++) {
			System.out.print("Please, enter the thruster capacity: ");
			int propellerCapacity = Keyboard.readInt();
			rocket.addThrusters(i, propellerCapacity);
		}
		return rocket;	
	}
	
	private static int calculateRace(Rocket rocket, int time, int startTime, int distance, int currentDistance) throws Exception {
		System.out.print("Please, enter acceleration:\n");
		int speedUp = Keyboard.readInt(), set;
		set = rocket.calculateSpeedDistance(speedUp, 2);
		set = (int) rocket.calculateFuel();	
		if(set == 0) { startTime += 2; }
		else { startTime += set; }
		System.out.print("Current time: " + startTime);	
		
		raceResults(speedUp, distance, rocket, currentDistance);
		return startTime;
	}
	
	private static int raceResults(int speedUp,int distance, Rocket rocket, int currentDistance) {	/*RACE RESULTS*/	
		System.out.print(" Acceleration: " + rocket.getAcceleration());
		System.out.print(" Speed: " + rocket.getSpeed());
		currentDistance += rocket.getDistance();
		System.out.print(" Distance: " + rocket.getDistance());
		System.out.print(" Circuit: " + distance);
		return currentDistance;
	}
	
	private static boolean fuelResults(int distance, Rocket coet, int currentDistance) {	/*FUEL RESULTS*/
		if (coet.getFuel() <= 0) {
			System.out.print(" Fuel: 0\n");
		} else {
			System.out.print(" Fuel: " + coet.getFuel() + "\n");
		}
		if(currentDistance >= distance && coet.getFuel() >= 0) {
			return true;
		}
		return false;
	}
	
	public static void finalScore(boolean end, int time, Rocket coet) {	/*FINAL SCORE*/
		if(end) {
			System.out.print("And the winner is: " + coet.getName() + " with a time of " + time);
		}else {
			System.out.print("There is no winner, sorry!");
		}
	}	
}
