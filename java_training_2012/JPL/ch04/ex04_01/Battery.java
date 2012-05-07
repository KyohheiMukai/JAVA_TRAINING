package ch04.ex04_01;

public class Battery implements EnergySource {

	private int percent;

	Battery(int percent){
		this.percent = percent;
	}

	@Override
	public boolean empty() {

		if(percent!=0)
			return true;
		else
			return false;
	}

}
