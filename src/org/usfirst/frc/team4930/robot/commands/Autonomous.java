//Thomas Kubiniec
// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team4930.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4930.robot.Robot;

/**
 *
 */
public class  Autonomous extends Command {

    public Autonomous() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    	//telling the code that it needs the designated "driveTrain" from the Robot.java file
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // THIS WILL ONLY RUN ONCE.
    protected void execute() {
    	
    	/* 
    	 * Autonoums Pseudocode
    	 * 
    	 * 1. drive x rotations
    	 * 2. intake tote
    	 * 3. lift tote
    	 * 4. lift can
    	 * 5. drive x rotations
    	 * 6. intake 2nd tote/lift 2nd tote
    	 * 7. turn 45 degrees
    	 * 8. drive x rotations(+, +)
    	 * 9. elevator down
    	 * 10. back away
    	 * 11. intake motors out
    	 */
    	
    	// ### 1 ###
    	
    	// be sure to always reset the encoders before beginning
    	Robot.encoders.resetBoth();
    	
    	// get the value for the left encoder
    	int leftEnc = Robot.encoders.getLeftDriveTrain();
    	
    	// get the value for the right encoder
    	int rightEnc = Robot.encoders.getRightDriveTrain();
    	
    	// run forward for 100 encoder rotations
    	while (leftEnc < 100 && rightEnc < 100) {
    		
    		// ### 2 ###
    		
        	// run intake motors
        	Robot.intake.rotate(-0.75);
        	// run drive motors
    		Robot.driveTrain.runMotors(0.5, 0.5);
		}
    	
    	Robot.intake.stop();
    	Robot.driveTrain.stop();
    	
    	// ### 3 ###
    	
    	Robot.elevator.move(0.5);
    	Timer.delay(1);
    	Robot.elevator.stop();
    	
    	// ### 4 ###
    	
    	Robot.arm.moveCan(0.5);
    	Timer.delay(1);
    	Robot.arm.stop();
    	
    	// ### 5 ###
    	
    	while (leftEnc < 50 && rightEnc < 50) {
        	// run drive motors
    		Robot.driveTrain.runMotors(0.5, 0.5);
		}
    	
    	
    	
    	
    	
    	
    	// ######## Code Below Is A Sample From Kiddy #########
    	
    	// run the drive train forward at full throttle
    	// range: -1.0 to 1.0
    	// left value = left pretend joystick value
    	// right value = right pretend joystick value
    	Robot.driveTrain.runMotors(1.0, 1.0);
    	
    	// timer delay for 2 seconds
    	Timer.delay(2);
    	
    	// stop the drive train motors
    	Robot.driveTrain.stop();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}