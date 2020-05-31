package domain;

public class Thruster {
	int thrusterCapacity;
	public Thruster(int thrusterCapacity) {
		if (thrusterCapacity < 0) {
			new Exception("Error. Negative capacity");
		}
		this.thrusterCapacity = thrusterCapacity;
	}
}
