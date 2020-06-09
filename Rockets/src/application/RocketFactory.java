package application;

import java.util.ArrayList;

import domain.Rocket;
import domain.Thruster;
import utilities.constantUtilities;

public class RocketFactory {
	
	public static Rocket creatRocket(int rocketID) throws Exception{
		if(rocketID == constantUtilities.FALCON_IX) {
			return new Rocket("Falcon IX", 2500);
		}
		if(rocketID == constantUtilities.SPEEDY_V) {
			return new Rocket("Speedy V", 2300);
		}
		if(rocketID == constantUtilities.STAR_V) {
			return new Rocket("Star V", 2800);
		}
		if(rocketID == constantUtilities.VIPER_X) {
			return new Rocket("Viper X", 2500);
		}
		throw new Exception("Invalid id");	
	}

}
