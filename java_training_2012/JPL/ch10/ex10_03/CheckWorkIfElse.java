package ch10.ex10_03;

public class CheckWorkIfElse {

	public boolean isWork(Week day){

		boolean check = false;

		if(day.equals(Week.MONDAY)){
			check = true;
		}else if(day.equals(Week.TUESDAY)){
			check = true;
		}else if(day.equals(Week.WEDNESDAY)){
			check = true;
		}else if(day.equals(Week.THURSDAY)){
			check = true;
		}else if(day.equals(Week.FRIDAY)){
			check = true;
		}else if(day.equals(Week.SATURDAY)){
			check = false;
		}else if(day.equals(Week.SUNDAY)){
			check = false;
		}

		return check;

	}

}
