package my.project.robocontrol;

public interface RoboCommands {

	public String execute();
	public RoboCommands createCommandObject(Robot robot, String commandLine);
	
}

