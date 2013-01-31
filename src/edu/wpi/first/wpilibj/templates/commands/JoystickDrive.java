
package edu.wpi.first.wpilibj.templates.commands;



/**
 *
 * @author Lauren Dierker and Jessie Adkins
 */
public class JoystickDrive extends CommandBase {

    public JoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.drive.mecanumDrive_Cartesian(oi.getSideSpeed(), oi.getForwardSpeed(), oi.getTwistSpeed(), 0);
        
        System.out.println(driveTrain.getTestEncoder());
        
        /**
        //forward = leftFront
        //works
        //backward
        
        if(oi.getForwardSpeed() > 0.1){
            driveTrain.leftFront.set(.5);
        }
        
        //backward = leftRear
        //full speed back runs left rear
        //backward
        if(oi.getForwardSpeed() < -0.1){
            driveTrain.leftRear.set(.5);
        }
        
        //twist left = rightFront
        //works
        //backwards 
        if(oi.getTwistSpeed() > 0.1){
            driveTrain.rightFront.set(.5);
        }
        
        //twist right = rightRear
        //works
        //backwards 
        if(oi.getTwistSpeed() < -0.1){
            driveTrain.rightRear.set(.5);
        }
         */
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
