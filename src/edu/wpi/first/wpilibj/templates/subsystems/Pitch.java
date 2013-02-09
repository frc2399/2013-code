
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.templates.RobotMap;
/**
 *
 * @author Jessie
 */
public class Pitch extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Jaguar pitchMot = new Jaguar(RobotMap.pitchMot);
    //this is different because it is a magnetic encoder
    public AnalogChannel pitchEncoder = new AnalogChannel(RobotMap.pitchEncoder);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * sets the speed of the pitch motor.  
     * @param speed speed of the pitch motor. 0 <= speed <= 1.
     */
    public void setSpeed(double speed){
        pitchMot.set(speed);
    }
    
    /**
     * 
     * @return returns the value of the pitch encoder
     */
    public double getEncoder(){
        return pitchEncoder.pidGet();
    }
}

