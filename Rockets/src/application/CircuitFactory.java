package application;

import java.util.Random;

import domain.Circuit;
import utilities.constantUtilities;
import view.Controller;

public class CircuitFactory {
	public static Circuit creatCircuit(int circuitID) throws Exception{

			return randomCircuit();
	}

	
	public static Circuit randomCircuit() throws Exception {
		//int[] circuit = {1,2,3,4};
		//int circuit;
		Random rand = new Random();
		int circuit = rand.nextInt(4) + 1;
		//int circuit = 2;
		//sController controller = new Controller();

        switch (circuit) 
        {
            case 1:  return new Circuit("Free World", 18, 1200);
   
            case 2:  return new Circuit("Mad Max", 22, 1300);
                     
            case 3:  return new Circuit("Rising Lap", 15, 900);
                    
            case 4:  return new Circuit("Speed Track", 10, 800);
                    
            default: throw new Exception("Error.");
        }
	}

}
