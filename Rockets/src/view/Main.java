package view;

import application.RocketController;
import application.dto.RocketDTO;
import domain.Rocket;
import utilities.constantUtilities;

public class Main {

	
	private static RocketController controller = new RocketController();
	
	public static void main(String[]args) throws Exception{
//		Circuit race = new Circuit("IceRace", 20, 1400);
//		race.startGame();
//		RocketDTO rocket = createRocket();
//		updateRocket(rocket.getId());
//		getRockets(rocket.getId());
		Controller controller = new Controller();
		controller.createRocket(constantUtilities.FALCON_IX);
		//controller.createRocket(constantUtilities.SPEEDY_V);
		//controller.createRocket(constantUtilities.STAR_V);
		//controller.createRocket(constantUtilities.VIPER_X);
		//randomCircuit();
//		if(circuit == 1)
		controller.createCircuits(constantUtilities.FREE_WORLD);
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
	}	
	
	public static void randomCircuit() throws Exception {
		//int[] circuit = {1,2,3,4};
		//circuit = (int[]) Math.random();
		int circuit = 2;
		
		Controller controller = new Controller();
		
        
        switch (circuit) 
        {
            case 1:  controller.createCircuits(constantUtilities.MAD_MAX);
                     break;
            case 2:  controller.createCircuits(constantUtilities.FREE_WORLD);
                     break;
            case 3:  controller.createCircuits(constantUtilities.RISING_LAP);
                     break;
            case 4:  controller.createCircuits(constantUtilities.SPEED_TRACK);
                     break;
      
        }
        //System.out.println(circuit);
	}
	
	public static void updateRocket(String id) throws Exception {
		RocketDTO rocket = new RocketDTO("latuyactm", 555);
		rocket = controller.updateRocket(id, rocket);
		System.out.print(rocket);
	}
	
	public static void getRockets(String id) throws Exception {
		RocketDTO rocket = controller.getRocket(id);
		System.out.print(rocket);
	}
	
	private static RocketDTO createRocket() throws Exception {
		RocketDTO rocket = new RocketDTO("tumama", 666);	//no te id
		rocket = controller.createRocket(rocket);
		System.out.println(rocket);
		return rocket;
	}	
}
