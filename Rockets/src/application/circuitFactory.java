package application;

import domain.Circuit;
import utilities.constantUtilities;

public class circuitFactory {
	public static Circuit creatCircuit(int circuitID) throws Exception{
		if(circuitID == constantUtilities.FREE_WORLD) {
			return new Circuit("Free World", 18, 1200);
		}
		if(circuitID == constantUtilities.MAD_MAX) {
			return new Circuit("Mad Max", 22, 1300);
		}
		if(circuitID == constantUtilities.RISING_LAP) {
			return new Circuit("Rising Lap", 15, 900);
		}
		if(circuitID == constantUtilities.SPEED_TRACK) {
			return new Circuit("Speed Track", 10, 800);
		}
		throw new Exception("Invalid id");	
	}

}
