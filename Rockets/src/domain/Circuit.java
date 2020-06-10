package domain;

import java.util.ArrayList;

import Keyboard.Keyboard;

public class Circuit {
	String name;
	protected int time;
	protected int distance;
	
	public Circuit(String name, int time, int distance) throws Exception {
		if(name.equals(null))throw new Exception("Empty name");
		if(time <= 0)throw new Exception("Wrong time");
		if(distance <= 0)throw new Exception("Wrong distance");
		this.name = name;
		this.time = time;
		this.distance = distance;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTime() {
		return time;
	}

	public int getDistance() {
		return distance;
	}

	//ha d'estar a Race
	public void startGame() throws Exception { /*START A NEW GAME*/
		boolean out = false;
		int startTime = 0, currentDistance = 0, set;
		Rocket rocket = createRocket();	
		rocket.getFuel();
		Tank fuelTank = new Tank(Tank.getfuelQuantity());
		rocket.getFuel();
		while(!out && startTime < time && Tank.getfuelQuantity() > 0) {	
			
			startTime = calculateRace(rocket, fuelTank, time, startTime, distance, currentDistance);
			calculateFuel(rocket, fuelTank);
			currentDistance = rocket.getDistance();
			//System.out.print(Rocket.getPropellerList());
			
			out = fuelResults(distance, rocket, currentDistance);
		}
		finalScore(out, startTime, rocket);		
	}
	
	private Rocket createRocket() throws Exception {	/*CREATES THE ROCKET*/
		String id = Rocket.getID();
		String rocketName = Rocket.getRocketName();
		//int thrustersQuantity = Thruster.addThrusters();
		ArrayList<Thruster> thrustersQuantity = Rocket.getPropellerList();
		double fuelQuantity = Tank.getfuelQuantity();
		Rocket rocket = new Rocket(id, rocketName,fuelQuantity, thrustersQuantity);
		//for(int i = 0; i < thrustersQuantity.size(); i++) {
			//System.out.print("Please, enter the thruster capacity: ");
			//int propellerCapacity = Keyboard.readInt();
			//rocket.getPropellerList();
		//}
		//return rocket;	
		return rocket;
	}
	
	private int enterAcceleration() {
		System.out.print("Please, enter acceleration:\n");
		int speedUp = Keyboard.readInt();
		return speedUp;
	}
	
	private int calculateSpeed(Rocket rocket) throws Exception {
		//int set;
		//set = 
		return rocket.calculateSpeedDistance(enterAcceleration(), 2);
	}
	
	private double calculateFuel(Rocket rocket, Tank fuelTank) {
		return fuelTank.calculateFuel(rocket);
	}
	
	private int calculateCurrentTime(int startTime) {
		return startTime;
	}
	
	
	
	private int calculateRace(Rocket rocket, Tank fuelTank, int time, int startTime, int distance, int currentDistance) throws Exception {
		System.out.print("Please, enter acceleration:\n");
		int speedUp = Keyboard.readInt(), set;
		set = rocket.calculateSpeedDistance(speedUp, 2);
		//fuelTank.calculateFuel(rocket);
		if(set == 0) { startTime += 2; }
		else { startTime += set; }
		System.out.print("Current time: " + startTime);	
		
		raceResults(speedUp, distance, rocket, currentDistance);
		return startTime;
	}
	
	public static void getAcc(Rocket rocket) {
		 rocket.getAcceleration();
	}
	
	public static int getSpeed(Rocket rocket) {
		return rocket.getSpeed();
	}
	
	public static int getDistance(Rocket rocket, int currentDistance) {
		currentDistance += rocket.getDistance();
		return currentDistance;
	}
	
	public static int getCircuit(int distance) {
		return distance;
	}
	
	public int raceResults(int speedUp,int distance, Rocket rocket, int currentDistance) {	/*RACE RESULTS*/	
		System.out.print(" Acceleration: " + rocket.getAcceleration());
		System.out.print(" Speed: " + rocket.getSpeed());
		currentDistance += rocket.getDistance();
		System.out.print(" Distance: " + rocket.getDistance());
		System.out.print(" Circuit: " + distance);
		return currentDistance;
	}
	
	public boolean fuelResults(int distance, Rocket coet, int currentDistance) {	/*FUEL RESULTS*/
		coet.getFuel();
		if (Tank.getfuelQuantity() <= 0) {
			System.out.print(" Fuel: 0\n");
		} else {
			coet.getFuel();
			System.out.print(" Fuel: " + Tank.getfuelQuantity() + "\n");
		}
		coet.getFuel();
		if(currentDistance >= distance && Tank.getfuelQuantity() >= 0) {
			return true;
		}
		return false;
	}
	
	public void finalScore(boolean end, int time, Rocket rocket) {	/*FINAL SCORE*/
		if(end) {
			System.out.print("And the winner is: " + rocket.getName() + " with a time of " + time);
		}else {
			System.out.print("There is no winner, sorry!");
		}
	}	
	
}
