package ch04.ex04_01;

public class GasTank implements EnergySource {

	private double fuel;

	GasTank(double fuel){
		this.fuel = fuel;
	}
	@Override
	public boolean empty() {

		if(fuel!=0.0)
			return true;
		else
			return false;

	}

}
