package domain;

import java.util.ArrayList;

//Circuit: IceRace: 1400 m, temps 20 segons. 
//Coet: un coet de cinc propulsors de 33,54,25, 10 i 8 i amb 3600 litres de dipòsit

public class Rocket {

	private static String name;
	private int acceleration;
	private int speed;
	private int distance;
	private Tank fuel;
	private  ArrayList <Thruster> propellerList;
	
	public Rocket(String coetName, double fuel) throws Exception {
		if(coetName == null) throw new Exception("Incorrect name.");
		if(fuel <= 0) throw new Exception("Empty fuel");
		name = coetName;
		this.acceleration = 0;
		speed = 0;
		this.distance = 0;
		this.fuel = new Tank(fuel);
		propellerList = new ArrayList<Thruster>();
		//this.propellerList = thrusterList;
	}
	

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	public static String getName() {
		return name;
	}
	
	public int getAcceleration() {
		return acceleration;
	}

	public int getSpeed() {
		return speed;
	}

	public int getDistance() {
		return distance;
	}

	public Tank getFuel() {
		return this.fuel;
	}
	
	public void addThrusters(int thrustersCapacity, int thrusterQuantity) throws Exception {	
		if(thrusterQuantity <= 0) throw new Exception("There are no propeller");
		Thruster propeller = new Thruster(thrustersCapacity, thrusterQuantity);
			this.propellerList.add(propeller);
	}
	
	public static String getRocketName() {	//ASK FOR COET NAME
		//System.out.print("What is the name of the rocket? ");
		String rocketName = getName();
		return rocketName;
	}
	
	public int calculateAcceleration(int acceleration, int time) throws Exception {	//Acceleration
		if (acceleration <= 0) {
			new Exception("Error. Negative acceleration");
		}
		int thrusters = 0;
		for (int i = 0; i < this.propellerList.size(); i++) {
			if (this.propellerList.get(i).getThrusterCapacity() > acceleration) {
				thrusters += acceleration;
			} else {
				thrusters += this.propellerList.get(i).getThrusterCapacity();
			}
			this.acceleration = thrusters;
		}
		return thrusters * time;
	}
	
	public int calculateSpeedDistance(int acceleration, int time) throws Exception { //Distance
		if (acceleration <= 0) {
			new Exception("Error. Negative acceleration");
		}
		int currentAcceleration;
		currentAcceleration = calculateAcceleration(acceleration, time);
		speed += currentAcceleration;
		this.distance += speed * time;
		return 0;
	}
	
	
	
}

