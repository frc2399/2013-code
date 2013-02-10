package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.Encoder;



/**
 *
 * @author Jessie
 */
public class NewEncoder extends Encoder{

    

    private double initialX;

    public double getInitialX() {
        return initialX;
    }

    public void setInitialX(int initialX) {
        this.initialX = initialX;
    }
    
    public double getDistance() {
        return super.getDistance() + initialX;
    }
    
    
    //a whole bunch of constructors
    public NewEncoder(DigitalSource aSource, DigitalSource bSource, DigitalSource indexSource) {
        super(aSource, bSource, indexSource);
    }

    public NewEncoder(DigitalSource aSource, DigitalSource bSource, DigitalSource indexSource, boolean reverseDirection) {
        super(aSource, bSource, indexSource, reverseDirection);
    }

    public NewEncoder(DigitalSource aSource, DigitalSource bSource, boolean reverseDirection, EncodingType encodingType) {
        super(aSource, bSource, reverseDirection, encodingType);
    }

    public NewEncoder(DigitalSource aSource, DigitalSource bSource) {
        super(aSource, bSource);
    }

    public NewEncoder(DigitalSource aSource, DigitalSource bSource, boolean reverseDirection) {
        super(aSource, bSource, reverseDirection);
    }

    public NewEncoder(int aChannel, int bChannel, int indexChannel) {
        super(aChannel, bChannel, indexChannel);
    }

    public NewEncoder(int aChannel, int bChannel, int indexChannel, boolean reverseDirection) {
        super(aChannel, bChannel, indexChannel, reverseDirection);
    }

    public NewEncoder(int aChannel, int bChannel, boolean reverseDirection, EncodingType encodingType) {
        super(aChannel, bChannel, reverseDirection, encodingType);
    }

    public NewEncoder(int aChannel, int bChannel) {
        super(aChannel, bChannel);
    }

    public NewEncoder(int aChannel, int bChannel, boolean reverseDirection) {
        super(aChannel, bChannel, reverseDirection);
    }

    public NewEncoder(int aSlot, int aChannel, int bSlot, int bChannel, int indexSlot, int indexChannel) {
        super(aSlot, aChannel, bSlot, bChannel, indexSlot, indexChannel);
    }

    public NewEncoder(int aSlot, int aChannel, int bSlot, int bChannel, int indexSlot, int indexChannel, boolean reverseDirection) {
        super(aSlot, aChannel, bSlot, bChannel, indexSlot, indexChannel, reverseDirection);
    }

    public NewEncoder(int aSlot, int aChannel, int bSlot, int bChannel, boolean reverseDirection, EncodingType encodingType) {
        super(aSlot, aChannel, bSlot, bChannel, reverseDirection, encodingType);
    }

    public NewEncoder(int aSlot, int aChannel, int bSlot, int bChannel) {
        super(aSlot, aChannel, bSlot, bChannel);
    }

    public NewEncoder(int aSlot, int aChannel, int bSlot, int bChannel, boolean reverseDirection) {
        super(aSlot, aChannel, bSlot, bChannel, reverseDirection);
    }
    
    
    
}
