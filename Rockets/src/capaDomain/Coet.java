package capaDomain;

import java.util.ArrayList;

//Circuit: IceRace: 1400 m, temps 20 segons. 
//Coet: un coet de cinc propulsors de 33,54,25, 10 i 8 i amb 3600 litres de dipòsit

public class Coet {

	private String name;
	private int acceleration;
	private int speed;
	private int distance;
	private double fuel;
	private ArrayList<Integer> mainPropulsor;
	// public int currentAcceleration;

	public Coet(String name) {
		this.name = name;
		this.speed = 0;
		this.distance = 0;
		this.fuel = 1000;
		this.mainPropulsor = new ArrayList<Integer>();
			this.mainPropulsor.add(33);
			this.mainPropulsor.add(54);
			this.mainPropulsor.add(25);
			this.mainPropulsor.add(10);
			//this.mainPropulsor.add(8);

	}

	public String getName() {
		return this.name;
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

	public double getFuel() {
		return this.fuel;
	}

	
	public int calculateAcceleration(int acceleration, int time) {
		int propulsors = 0;
		for (int i = 0; i < this.mainPropulsor.size(); i++) {
			if(this.mainPropulsor.get(i) > acceleration) {
				propulsors += acceleration;
	    	}else {
	    		propulsors += this.mainPropulsor.get(i);
			}
			this.acceleration = propulsors;
		}
		return propulsors * time;
	}
	
	public int calculateSpeedDistance(int acceleration, int time) {
		int currentAcceleration;
		currentAcceleration = calculateAcceleration(acceleration, time);
		speed += currentAcceleration;
		this.distance += this.speed;

		return 0;
	}
	
	public double calculateFuel() {
		fuel = fuel - (0.02 * Math.pow(speed, 2));
		return 0;
	}
	
}

