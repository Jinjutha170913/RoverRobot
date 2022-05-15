package my.project.robocontrol;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class CommandController {
private Robot robot;
private Scanner inputScanner;
private String output;

   public CommandController(Robot rbt, String fileName)
   {
	   this.robot = rbt;
	 try{
		 if(fileName != null)
		 {
		    inputScanner = new Scanner(new File(fileName));
		 }else
		 {
			 inputScanner = new Scanner(System.in);
			 System.out.println("Enter commands to control your ROBOT(enter EXIT to exit the code):");
		 }
	 }catch(FileNotFoundException fe)
	 {
		 System.out.println("Please provide a valid file. " + fileName +" could not be found" + fe.getMessage());
	 }
   }
   
   public String executeCommands()
   {
	   RoboCommands roboCommand;
	   while(true)
	   {
		   roboCommand = getNextCommand();
		   if (null == roboCommand || roboCommand instanceof ExitCommand  )
		   {
			   return output;
		   }else{
			   output = roboCommand.execute();
			   
		   }
	   }
	 
   }
 
   public RoboCommands getNextCommand()
   {
	   RoboCommands roboCommand=null;
	   if(inputScanner == null)
	   {
		   return (new ExitCommand(robot, ""));
	   }
	   
	   while(null == roboCommand)
	   {
		   if (!inputScanner.hasNextLine()){
			   return null;
		   } 
		   
		   String commandLine = inputScanner.nextLine().toUpperCase();
		   
		   roboCommand = CommandFactory.getInstance().getCommand(robot,commandLine);
		   
       }
	   return roboCommand;
   }
}
