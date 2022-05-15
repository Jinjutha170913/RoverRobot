package my.project.robocontrol;

public enum DIRECTIONS{
	N //NORTH
	{
		public Coordinates moveInDirection(Coordinates xy){
			xy.incrementY();
			return xy;
		}
			
	},
	E //EAST
	{
		public Coordinates moveInDirection(Coordinates xy){
			xy.incrementX();
			return xy;
		}
	},
	S //SOUTH
	{
		public Coordinates moveInDirection(Coordinates xy){
			xy.decrementY();
			return xy;
		}
	},
	
	W //WEST
	{
		public Coordinates moveInDirection(Coordinates xy){
			xy.decrementX();
			return xy;
		}
	};
	public final int NOOFDIRECTIONS = 4;
	public abstract Coordinates moveInDirection(Coordinates xy);
}