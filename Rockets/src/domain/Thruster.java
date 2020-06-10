package domain;

import Keyboard.Keyboard;

//cada propulsor té la seva acceleració
public class Thruster {

	private int thrusterCapacity;
	private int thrusterQuantity;

	public Thruster(int capacity) throws Exception {
		if(capacity <= 0) throw new Exception("Error. Negative capacity");
		this.thrusterCapacity = capacity;
		//this.thrusterQuantity = quantity;
	}
	
	public int getThrusterQuantity() {
		return thrusterQuantity;
	}

	public int getThrusterCapacity() {
        return thrusterCapacity;
    }
	
	public static int addThrusters() {	/*ASK FOR THRUSTERS QUANTITY*/
		System.out.print("How many propellers does the rocket have? ");
		int thrustersQuantity = Keyboard.readInt();
		return thrustersQuantity;
	}
}
