package ch03.ex03_06;

public class Battery extends EnergySource {

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
