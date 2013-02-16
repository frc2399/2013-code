
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jessie, Lauren, and Amanda
 */
public class ShootOff extends CommandBase {

    public ShootOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    //sets speed to zero
    protected void initialize() {
        //shooter.setShooterSpeed(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    //THIS WILL ALWAYS END!!!!!! YAY!
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
