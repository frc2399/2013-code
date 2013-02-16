
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem; 
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class Shooter extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    //might be correct port #
    //if this fails, ask electrical if it is actually plugged into this port
    //might not be a Jag
    
    public Encoder shootEncoder = new Encoder(RobotMap.shootEncoderA, RobotMap.shootEncoderB);
    public CANJaguar shootMot;
    
    public Shooter(){
        super(0.001, 0, 0);
        /**
        try {
            shootMot = new CANJaguar(RobotMap.shootMot);
        }catch(Exception e){
            System.out.println(e);
        }
         */
        
    }

    //not setting a default command at the moment
    //there is no default in 2012 code
    //not sure why, no comments
    //might make never ending things happen!
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput(){
        return shootEncoder.pidGet();
    }
    
    protected void usePIDOutput(double output){
        //TEST THIS
        //this is really small so that the robot does not decapitatie itself!
        /**
        try{
            shootMot.setX(output);
        }catch(Exception e){
            
        }
         */ 
        
    }
    
    public void setShooterSpeed(double speed){
        //shootMot.set(speed);

        
        /**
         * 
         try{
            shootMot.setX(speed);
        }catch(Exception e){
            
        }
         */ 
    }
    
    
}


