package view;


import application.RaceController;
import application.RocketController;
import application.dto.CircuitDTO;
import application.dto.RocketDTO;

import domain.Rocket;
import utilities.constantUtilities;

public class Main {

	
	private static RocketController controller = new RocketController();
	private static RaceController circuitController = new RaceController();
	
	public static void main(String[]args) throws Exception{
		//Circuit race = new Circuit(UUID.randomUUID().toString(),"IceRace", 20, 1400);
//		race.startGame();
		
		Controller controller = new Controller();
		controller.createRocket(constantUtilities.FALCON_IX);
		//controller.createRocket(constantUtilities.SPEEDY_V);
		//controller.createRocket(constantUtilities.STAR_V);
		//controller.createRocket(constantUtilities.VIPER_X);
		//randomCircuit();
//		if(circuit == 1)
		controller.createCircuits();
//		if(circuit == 2)
//		controller.createCircuits(constantUtilities.MAD_MAX);
//		if(circuit == 3)
//		controller.createCircuits(constantUtilities.RISING_LAP);
//		if(circuit == 4)
//		controller.createCircuits(constantUtilities.SPEED_TRACK);
		//System.out.print(controller.getCircuit());
		//System.out.print(controller.printRockets());
		//System.out.print(controller.printCircuits());
		controller.startCompetition();
		RocketDTO rocket = createRocket();
		//updateRocket(rocket.getId());
		//getRockets(rocket.getId());
		CircuitDTO circuit = createCircuit();
		//updateCircuit(circuit.getId());
		//getCircuit(circuit.getId());
	}	
	

	
	public static void updateRocket(String id) throws Exception {
		RocketDTO rocket = new RocketDTO("hola", 555);
		rocket = controller.updateRocket(id, rocket);
		System.out.print(rocket);
	}
	
	public static void getRockets(String id) throws Exception {
		RocketDTO rocket = controller.getRocket(id);
		System.out.print(rocket);
	}
	
	private static RocketDTO createRocket() throws Exception {
		RocketDTO rocket = new RocketDTO(Rocket.getName(), 666);	//no te id
		rocket = controller.createRocket(rocket);
		System.out.println(rocket);
		return rocket;
	}	
	
	private static CircuitDTO createCircuit() throws Exception {
		CircuitDTO circuitDTO = new CircuitDTO("circuit1", 12, 222);	//no te id
		circuitDTO = circuitController.createCircuit(circuitDTO);
		System.out.println(circuitDTO);
		return circuitDTO;
	}
	
	public static void updateCircuit(String id) throws Exception {
		CircuitDTO circuit = new CircuitDTO("LAND", 12, 1500);
		circuit = circuitController.updateCircuit(id, circuit);
		System.out.print(circuit);
	}
	
	public static void getCircuit(String id) throws Exception {
		CircuitDTO circuit = circuitController.getCircuit(id);
		System.out.print(circuit);
	}
}
