package view;

import java.util.ArrayList;
import java.util.List;

import Keyboard.Keyboard;
import application.CircuitFactory;
import application.RocketFactory;
import domain.Circuit;
import domain.Rocket;
import domain.Tank;
import domain.Thruster;

public class Controller {
	
	private List <Rocket> rockets = new ArrayList<>();
	private List <Circuit> circuits = new ArrayList<>();
	
	public void createRocket(int rocketID) throws Exception {
		Rocket rocket = RocketFactory.creatRocket(rocketID);
		addRocket(rocket);
		System.out.printf("Rocket: "+ rocket.getName() + "\n");
		
	}
	
	public void createCircuits() throws Exception {
		Circuit circuit = CircuitFactory.creatCircuit();
		addCircuit(circuit);
	
		
		System.out.print("------------------------------------\n");
		System.out.print("Starting competition. "
				+ "Circuit: " + circuit.getName() + " Length: " + circuit.getDistance() 
				+ ". Max time: " + circuit.getTime() + "\n");
		
	}
	
	public void startCompetition() throws Exception {
			for(Circuit circuit : circuits) {
					initializeCircuit(circuit);
			}
	}
	
	private void addRocket(Rocket rocketCompetitor) {
		this.rockets.add(rocketCompetitor);
	}
	
	private void addCircuit(Circuit circuitCompetition) {
		this.circuits.add(circuitCompetition);
	}
	
	private void initializeCircuit(Circuit circuitInit) throws Exception {
		circuitInit.startGame();
	}
	
	List <Rocket> getRockets(){
		return rockets;
	}
	
	List <Circuit> getCircuit(){
		return circuits;
	}
	
	public String printRockets() {
		String result = "";
		for(Rocket rocket : rockets) {
			rocket.getFuel();
			result += rocket.getName() + " " + Tank.getfuelQuantity() + "\n";
		}
		return result;
	}
	
	public String printCircuits() {
		String result = "";
		for(Circuit circuit : circuits) {
			result += circuit.getName() + " " 
				+ circuit.getTime() + " "
				+ circuit.getDistance() + "\n" ;
		}
		return result;
	}	

}
