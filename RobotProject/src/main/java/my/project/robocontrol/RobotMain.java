package my.project.robocontrol;

public class RobotMain {

	public static void main(String[] args) {
		Robot robot = new Robot();
		CommandController robotCommandController;
		
		if (args.length > 0)
		{
			robotCommandController = new CommandController(robot, args[0]);
		}
		else
		{
			robotCommandController = new CommandController(robot, null);
		}
		robotCommandController.executeCommands();
		
	}

}
