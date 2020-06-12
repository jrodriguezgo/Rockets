package application.dto;

import domain.Rocket;
import domain.Tank;

public class RocketDTO {
	
	private String id;
	private String name;
	private Tank fuelTank;
	
	public RocketDTO(String name, double fuelTank) throws Exception {
		if(name == null) throw new Exception("Empty name");
		if(fuelTank < 0) throw new Exception("Empty fuel");
		this.name = name;
		this.fuelTank = new Tank(fuelTank);
	}
	
	public RocketDTO(Rocket rocket) {
		if(rocket == null) new Exception("Error.");
		this.id = rocket.getID();
		this.name = Rocket.getName();
		this.fuelTank = rocket.getFuel();
	}

	public String getId() throws Exception {
		if(id == null || id.equals("")) new Exception("Error.");
		return id;
	}

	public String getName() throws Exception {
		if(name == null || name.equals("")) new Exception("Error.");
		return name;
	}

	public Tank getFuelTank() throws Exception {
		if(fuelTank == null || fuelTank.equals("")) new Exception("Error.");
		return fuelTank;
	}

	public String toString() {
		return "\nROCKET " + this.id + " name: " + this.name;
	}
	

}
