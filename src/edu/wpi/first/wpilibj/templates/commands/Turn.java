
package edu.wpi.first.wpilibj.templates.commands;



/**
 * Turns the robot a given angle
 * this command ends.
 * @author Jessie
 */
public class Turn extends CommandBase {

    double angle;
    double speed;
    /**
     * 
     * @param angle angle the robot turns.  measured in degrees (positive = counter, negative = clockwise), and numbers higher than 360 are okay
     * @param speed speed of the robot as it turns.  0 <= speed <= 1.
     */
    public Turn(double angle, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        driveTrain.resetGyro();
        this.angle = angle;
        this.speed = speed;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(angle >= 0){
            driveTrain.drive.mecanumDrive_Cartesian(0, 0, speed, 0);
        }else{
            driveTrain.drive.mecanumDrive_Cartesian(0, 0, -speed, 0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Math.abs(driveTrain.getGyroAngle()) >= Math.abs(angle)){
            return true;
        }else{
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.resetGyro();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
