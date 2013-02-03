package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.PIDOutput;



/**
 *
 * @author Jessie
 */
public class PIDOutputTranslator implements PIDOutput{
    
    private double value;
    
    public void pidWrite(double output){
        value = output;
    }
    
    public double getValue(){
        return value;
    }
    
}
