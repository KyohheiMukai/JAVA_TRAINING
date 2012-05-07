package ch03.ex03_06;

public class GasTank extends EnergySource {

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
