
package edu.wpi.first.wpilibj.templates.commands;

/**
 * Resets the gyro defined in the driveTrain subsystem.  
 * This class ends.
 * @author Jessie
 */
public class GyroReset extends CommandBase {

    public GyroReset() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    //resets the gyro made in the driveTrain subsystem
    protected void initialize() {
        driveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    //in this command, you only need to use initialize, so isFinished() will always
    //return true, so this ends promptly
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
