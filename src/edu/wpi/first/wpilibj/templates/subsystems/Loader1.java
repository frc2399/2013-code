
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;

/**
 * AKA MAGAZINE
 * @author Jessie
 */
public class Loader1 extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Victor loadMot1 = new Victor(RobotMap.loadMot1);
    
    //THESE NEED TO BE TESTED OUT
    //THE VALUES RANGE FROM 0 to 4095
    //THEY ARE ARBITRARY
    //0 is potentially -10V
    public AnalogChannel loadEncoder1 = new AnalogChannel(RobotMap.loadEncoder1);
    
    
    public Loader1(){
        super(0.000001, 0, 0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSetpoint(double angle){
        getPIDController().setSetpoint(angle);
    }
    
    protected double returnPIDInput(){
        return loadEncoder1.pidGet();
    }
    
    protected void usePIDOutput(double output){
        //TEST THIS
        //this is really small so that the robot does not freak out!
        loadMot1.set(output * 0.1);
    }
}

