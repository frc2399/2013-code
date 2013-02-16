
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author Jessie, Lauren, and Amanda
 */
public class ShootOn extends CommandBase {

    double speed;
    
    public ShootOn(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //shooter.setSetpoint(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    //ends command if the speed of the shooter is greater than or equal to the input speed
    protected boolean isFinished() {
        return shooter.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
