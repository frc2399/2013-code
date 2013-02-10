
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jessie
 */
public class LoadDisk extends CommandBase {

    public LoadDisk() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(loader1);
        requires(loader2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(loader1.getPosition() != loader2.getPosition()){
            loader2.setSetpoint(loader1.getPosition());
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //needs to rotate 90 degrees
        if(loader1.triggerSensor.get() == false){
            if(loader1.topSensor.get() == true){
                if(loader1.bottomSensor.get() == false){
                    //loader1.setSetpoint(90);
                    //loader2.setSetpoint(90);
                }else{
                    //do nothing!
                }
            }else{
                //do nothing, I think
            }
        }else{
            //do nothing, I think
        }
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
