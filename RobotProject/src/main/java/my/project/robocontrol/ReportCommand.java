package my.project.robocontrol;

public class ReportCommand implements RoboCommands {
	Robot robot;
	String report;
	
	static
	{
		Robot tempRobot = null;
		CommandFactory.getInstance().registerCommand("REPORT", new ReportCommand(tempRobot, ""));
	}
	
	public ReportCommand(Robot robot, String command)
	{
		this.robot = robot;
	}
	
	public ReportCommand createCommandObject(Robot robot, String commandLine)
	{
		return new ReportCommand(robot, commandLine);
	}
	
	public String execute()
	{
		if(robot != null){
			report = robot.report();
			if(report != null){
				
				System.out.println("Robot Position :" + report);
				return report;
			}
			
		}
		report ="Robot not placed on the Table";
		System.out.println("Robot Position :" + report);
		return report;
		
	}

}
