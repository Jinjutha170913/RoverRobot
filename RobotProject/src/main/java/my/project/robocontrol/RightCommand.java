package my.project.robocontrol;

public class RightCommand implements RoboCommands {
private Robot robot;

static
{
	Robot tempRobot = null;
	CommandFactory.getInstance().registerCommand("R", new RightCommand(tempRobot, "")); //RIGHT
}
	public RightCommand(Robot robot, String command)
	{
	   this.robot = robot;
	}
	
	public RightCommand createCommandObject(Robot robot, String commandLine)
	{
		return new RightCommand(robot, commandLine);
	}
	
	public String execute()
	{
		if(robot!= null && robot.isRobotPlaced())
		{
			robot.turnRight();
		}
		return null;
	   
	}
}
