package domain;

import java.util.ArrayList;

//Circuit: IceRace: 1400 m, temps 20 segons. 
//Coet: un coet de cinc propulsors de 33,54,25, 10 i 8 i amb 3600 litres de dipòsit

public class Rocket {

	private String name;
	private int acceleration;
	private int speed;
	private int distance;
	private double fuel;
	private ArrayList<Integer> propeller;

	public Rocket(String name) throws Exception {
		if (name != null && name.compareTo("") != 0) {
			this.name = name;
		} else
			throw new IllegalArgumentException("Dades incorrectes");
		this.speed = 0;
		this.distance = 0;
		this.fuel = 3600;
		this.propeller = new ArrayList<Integer>();
		this.propeller.add(33);
		this.propeller.add(54);
		this.propeller.add(25);
		this.propeller.add(10);
		this.propeller.add(8);
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
		int thrusters = 0;
		for (int i = 0; i < this.propeller.size(); i++) {
			if (this.propeller.get(i) > acceleration) {
				thrusters += acceleration;
			} else {
				thrusters += this.propeller.get(i);
			}
			this.acceleration = thrusters;
		}
		return thrusters * time;
	}

	public int calculateSpeedDistance(int acceleration, int time) {
		int currentAcceleration;
		currentAcceleration = calculateAcceleration(acceleration, time);
		speed += currentAcceleration;
		this.distance += this.speed * time;
		return 0;
	}

	public double calculateFuel() {
		fuel = fuel - (0.02 * Math.pow(speed, 2));
		return 0;
	}

}
