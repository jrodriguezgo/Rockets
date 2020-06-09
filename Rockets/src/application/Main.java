package application;

import domain.Rocket;
import utilities.constantUtilities;
import view.Controller;

public class Main {
	
	public static void main(String[]args) throws Exception{
//		Circuit race = new Circuit("IceRace", 20, 1400);
//		race.startGame();
		Controller controller = new Controller();
		controller.createRocket(constantUtilities.FALCON_IX);
//		controller.createRocket(constantUtilities.SPEEDY_V);
//		controller.createRocket(constantUtilities.STAR_V);
//		controller.createRocket(constantUtilities.VIPER_X);
		controller.createCircuits(constantUtilities.FREE_WORLD);
//		controller.createCircuits(constantUtilities.MAD_MAX);
//		controll2er.createCircuits(constantUtilities.RISING_LAP);
//		controller.createCircuits(constantUtilities.SPEED_TRACK);
		
		//System.out.print(controller.printRockets());
		//System.out.print(controller.printCircuits());
		controller.startCompetition();
	}	
}
