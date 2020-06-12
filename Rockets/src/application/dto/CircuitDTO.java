package application.dto;

import domain.Circuit;

public class CircuitDTO {
	
	private String id;
	private String name;
	private int bestTime;
	private int distance;
	
	public CircuitDTO(String name, int bestTimeRecord, int distance) throws Exception {
		if (name == null) throw new Exception("Empty name");
		if (bestTimeRecord < 0) throw new Exception("Empty time");
		if(distance < 0)throw new Exception("Empty time");
		this.name = name;
		this.bestTime = bestTimeRecord;
		this.distance = distance;
	}

	public CircuitDTO(Circuit circuit) throws Exception {
		if(circuit == null) throw new Exception("Error.");
		this.id = circuit.getId();
		this.name = circuit.getName();
		this.bestTime = circuit.getStartTime();
		this.distance = circuit.getDistance();
	}
	
	public String getId() throws Exception {
		if(id == null || id.equals("")) new Exception("Error.");
		return id;
	}

	public String getName() {
		if(name == null || name.equals("")) new Exception("Error.");
		return name;
	}

	public int getBestTime() {
		if(bestTime < 0) new Exception("Error.");
		return bestTime;
	}
	
	public int getDistance() {
		if(distance < 0) new Exception("Error.");
		return distance;
	}
	
	public String toString() {
		return "\nCIRCUIT " + this.id + "\nNAME: " + this.name + "\nTIME:" + this.bestTime
		+ "\nDISTANCE: "+ this.distance;
	}

}
