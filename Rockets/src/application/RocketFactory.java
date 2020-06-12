package application;
import java.util.ArrayList;
import java.util.UUID;

import domain.Rocket;
import domain.Thruster;
import utilities.constantUtilities;

public class RocketFactory {
	
	public static Rocket creatRocket(int rocketID) throws Exception{
		if(rocketID == constantUtilities.FALCON_IX) {
			return new Rocket(UUID.randomUUID().toString(),"Falcon IX", 2500, addThrusters(new int[] {40,29,60}));
		}
		if(rocketID == constantUtilities.SPEEDY_V) {
			return new Rocket(UUID.randomUUID().toString(),"Speedy V", 2300, addThrusters(new int[] {10,3,20,82}));
		}
		if(rocketID == constantUtilities.STAR_V) {
			return new Rocket(UUID.randomUUID().toString(),"Star V", 2800, addThrusters(new int[] {30,18,24,38}));
		}
		if(rocketID == constantUtilities.VIPER_X) {
			return new Rocket(UUID.randomUUID().toString(),"Viper X", 2500, addThrusters(new int[] {40,50,20,38}));
		}
		throw new Exception("Invalid id");		
	}
	
	public static ArrayList <Thruster> addThrusters(int[] capacity) throws Exception {
		ArrayList <Thruster> thrusters = new ArrayList<Thruster>();
		for(int acceleration : capacity) {
			thrusters.add(new Thruster(acceleration));
		}
		return thrusters;
	}

}
