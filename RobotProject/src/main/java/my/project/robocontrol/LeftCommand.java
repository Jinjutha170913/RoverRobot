package my.project.robocontrol;

public class LeftCommand implements RoboCommands{
private Robot robot;

static
{
	Robot tempRobot = null;
	CommandFactory.getInstance().registerCommand("L", new LeftCommand(tempRobot, "")); //LEFT
}
    public LeftCommand(Robot robot, String commandLine)
    {
    	this.robot = robot;
    }
	public String execute()
	{
		if(robot!= null && robot.isRobotPlaced())
		{
			robot.turnLeft();
		}
		return null;
	}
	
	public LeftCommand createCommandObject(Robot robot, String commandLine)
	{
		return new LeftCommand(robot, commandLine);
	}
}
