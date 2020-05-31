package domain;

public class Tank {
	private int fuelQuantity;
	public Tank(int fuelQuantity) throws Exception{
		if(fuelQuantity <= 0) {
			throw new Exception("Incorrect fuel capacity");
		}
		this.fuelQuantity = fuelQuantity;
	}
	public int getfuelQuantity() {
		return this.fuelQuantity;
	}
}
