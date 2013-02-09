
package edu.wpi.first.wpilibj.templates.commands;



/**
 * 
 * @author Jessie
 */
public class Fire extends CommandBase {
    
    double angle;

    /**
     * 
     * @param angle the amount it should turn.  Must be between 0 and 1! 0 is full left, 1 is full right
     */
    public Fire(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(trigger);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        trigger.triggerMot.set(angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
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
