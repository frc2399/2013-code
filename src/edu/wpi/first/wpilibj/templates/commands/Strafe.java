
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Lauren Dierker
 * This class makes the robot move sideways either left or right so that the chosen target is centered.
 */
public class Strafe extends CommandBase {

    double speed;
    long beginTime;
    long endTime;
    
    /**
     * 
     * @param speed the seed for sideways motion
     * Do not set the seed to a high number
     */
    public Strafe(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        beginTime = Timer.getUsClock()/ 1000;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.drive.mecanumDrive_Cartesian(speed, 0, 0, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        endTime = Timer.getUsClock()/ 1000;
        //System.out.println( beginTime- endTime);
        
        //run for two seconds, and then stop
        if( endTime - beginTime >= 2000){
            return true;
        } else{
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
