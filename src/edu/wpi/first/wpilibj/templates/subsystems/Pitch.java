
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ManPitch;
/**
 *
 * @author Jessie
 */
public class Pitch extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Jaguar pitchMot = new Jaguar(RobotMap.pitchMot);
    //this is different because it is a magnetic encoder
    public AnalogChannel pitchEncoder = new AnalogChannel(RobotMap.pitchEncoder);
    
    final double MinAngle = 0;
    final double MaxAngle = 35;
    
    public Pitch(){
        super(0.000001, 0, 0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ManPitch());
    }
    
    public void setSetpoint(double angle){
        //this is to make sure the robot does not decapitatie itself
        if (angle > MaxAngle) {
            angle = MaxAngle;
        } else if (angle < MinAngle) {
            angle = MinAngle;
        }
        //this is the part that actually does something involving the controller
        getPIDController().setSetpoint(angle);
    }
    
    protected double returnPIDInput(){
        return pitchEncoder.pidGet();
    }
    
    protected void usePIDOutput(double output){
        //TEST THIS
        //this is really small so that the robot does not decapitatie itself!
        pitchMot.set(output * 0.1);
    }
    
    
    
    /**
     * sets the speed of the pitch motor.  
     * @param speed speed of the pitch motor. -1 <= speed <= 1.
     */
    public void setSpeed(double speed){
        pitchMot.set(speed);
    }
    
    
}

