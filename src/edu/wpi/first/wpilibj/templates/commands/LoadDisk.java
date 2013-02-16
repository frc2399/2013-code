
package edu.wpi.first.wpilibj.templates.commands;


/**
 *
 * @author Jessie
 */
public class LoadDisk extends CommandBase {

    double intervalA1;
    double intervalA2;
    double intervalA3;
    double intervalA4;
    
    double intervalB1;
    double intervalB2;
    double intervalB3;
    double intervalB4;
    
    public LoadDisk() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(loader1);
        requires(loader2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //if(loader1.getPosition() != loader2.getPosition()){
            //loader2.setSetpoint(loader1.getPosition());
        //}
        
        //SYNC LOADER 1!
        
        //constant used for tuning the initial position of loader 1
        
        double x = 0;
        
        intervalA1 = 0 + x;
        intervalA2 = 90 + x;
        intervalA3 = 180 + x;
        intervalA4 = 270 + x;
        
        double distA1 = Math.abs(intervalA1 - loader1.getPosition());
        double distA2 = Math.abs(intervalA2 - loader1.getPosition());
        double distA3 = Math.abs(intervalA3 - loader1.getPosition());
        double distA4 = Math.abs(intervalA4 - loader1.getPosition());
        
        double[] distListA = new double[4];
        
        distListA[1] = distA1;
        distListA[2] = distA2;
        distListA[3] = distA3;
        distListA[4] = distA4;
        
        double minDistA = 360;
        int minDistIndexA;
        
            for(int i = 0; i < 3; i++){
                if(distListA[i] < minDistA){
                    minDistA = distListA[1];
                    minDistIndexA = i;
                }
            }
            
        loader1.setSetpoint(minDistA);
        
        //AND NOW ON TO LOADER 2!
        
        intervalB1 = loader1.getPosition();
        intervalB2 = loader1.getPosition() + 90;
        intervalB3 = loader1.getPosition() + 180;
        intervalB4 = loader1.getPosition() + 270;
        
        double dist1 = Math.abs(intervalB1 - loader2.getPosition());
        double dist2 = Math.abs(intervalB2 - loader2.getPosition());
        double dist3 = Math.abs(intervalB3 - loader2.getPosition());
        double dist4 = Math.abs(intervalB4 - loader2.getPosition());
        
        double[] distList = new double[4];
        
        distList[0] = dist1;
        distList[1] = dist2;
        distList[2] = dist3;
        distList[3] = dist4;
        
        double minDist = 360;
        int minDistIndex;
        
        if(Math.abs(loader1.getPosition() - loader2.getPosition()) > 3){
            for(int i = 0; i < 3; i++){
                if(distList[i] < minDist){
                    minDist = distList[1];
                    minDistIndex = i;
                }
            }
            
            loader2.setSetpoint(minDist);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //needs to rotate 90 degrees
        
        /**
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
