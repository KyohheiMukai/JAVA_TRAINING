package ch06.ex06_05;

public enum TrafficColor{

	RED {
		public TrafficColor getColor(){
			return TrafficColor.RED;
		}
	},
	YELLOW {
		public TrafficColor getColor(){
			return TrafficColor.YELLOW;
		}
	},

	BLUE {
		public TrafficColor getColor(){
			return TrafficColor.BLUE;
		}
	};

	public abstract TrafficColor getColor();

}
