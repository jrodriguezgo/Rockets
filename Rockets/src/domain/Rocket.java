package domain;

import java.util.ArrayList;

//Circuit: IceRace: 1400 m, temps 20 segons. 
//Coet: un coet de cinc propulsors de 33,54,25, 10 i 8 i amb 3600 litres de dipòsit

public class Rocket {

	private String name;
	private int acceleration;
	private int speed;
	private int distance;
	private Tank fuel;
	//llista ha de serde propulsors
	private ArrayList<Thruster> propellerList;

	public Rocket(String name, ArrayList<Thruster> propeller, Tank fuel) throws Exception {
		if (name == null || name.isEmpty())
			throw new Exception("Incorrect name");
		this.name = name;
		this.speed = 0;
		this.distance = 0;
		this.fuel = fuel;
		this.propellerList = new ArrayList<Thruster>();
		
		//cambiar
		/*
		 for (int i = 0; i < thrusters; i++) {
			this.propeller.add(0);
		}
		*/
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

	public void addThrusters(Thruster thruster) {
		this.propellerList.add(thruster);
	}

	public int calculateAcceleration(int acceleration, int time) throws Exception {
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

	public int calculateSpeedDistance(int acceleration, int time) throws Exception {
		if (acceleration <= 0) {
			new Exception("Error. Negative acceleration");
		}
		int currentAcceleration;
		currentAcceleration = calculateAcceleration(acceleration, time);
		speed += currentAcceleration;
		this.distance += this.speed * time;
		return 0;
	}

	public double calculateFuel() {
		double currentFuel = this.fuel.getfuelQuantity() - (0.02 * Math.pow(speed, 2));
		this.fuel.setfuelQuantity(currentFuel);
		return currentFuel;
	}

}
