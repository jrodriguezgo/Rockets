package domain;

public class Tank {
	private double fuelQuantity;
	public Tank(double fuelQuantity) throws Exception{
		if(fuelQuantity <= 0) {
			throw new Exception("Incorrect fuel capacity");
		}
		this.fuelQuantity = fuelQuantity;
	}
	
	public double getfuelQuantity() {
		return this.fuelQuantity;
	}
	
	public void setfuelQuantity(double fuelQuantity) {
		this.fuelQuantity = fuelQuantity;
	}
	
}
