package ch10.ex10_03;

public class CheckWorkSwitch {

	public boolean isWork(Week day){

		boolean check = false;

		switch(day){
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			check = true;
		case SATURDAY:
		case SUNDAY:
			check = false;
		}

		return check;
	}

}
