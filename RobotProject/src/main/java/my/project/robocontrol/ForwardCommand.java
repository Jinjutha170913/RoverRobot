package my.project.robocontrol;

public class ForwardCommand implements RoboCommands {
	private Robot robot;
	private String command;
	private Coordinates newXYCoordinates;
	private DIRECTIONS robotDirection;
	static
	{
		Robot tempRobot = null;
		CommandFactory.getInstance().registerCommand("F", new ForwardCommand(tempRobot, "")); //Forward
	}
  public ForwardCommand(Robot robot, String command)
  {
	this.robot = robot;
	this.command = command;
  }
  
  public String execute()
  {
	  if(robot!= null && robot.isRobotPlaced())
	  {
		  newXYCoordinates = new Coordinates(robot.getCoordinates());
		  robotDirection = robot.getDirection();
		  newXYCoordinates = robotDirection.moveInDirection(newXYCoordinates);
		  if(Table.getInstance().isOnTable(newXYCoordinates))
		  {
		    robot.move();
		  }
	  }
	return null;
  }
  
  public ForwardCommand createCommandObject(Robot robot, String commandLine)
	{
		return new ForwardCommand(robot, commandLine);
	}
}
