package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.commands.Strafe;
/**
 *
 * @author Lauren Dierker
 */
public class TestVision extends CommandBase {

    AxisCamera camera;
    CriteriaCollection cc;
    //used in first Dealy
    //set to false during execution
    boolean foo = true;
    final double topHeightFromGround = 104.125;
    final double middleHeightFromGround = 88.625;
    final double lowHeightFromground = 19;
    final double pyramidHeightFromGround = 0; //find this later...
    final double topWidth = 62;
    final double middleWidth = 62;
    final double lowWidth = 29;
    final double topHeight = 20;
    final double middleHeight = 29;
    final double cameraHeight = 0; //we dont know yet (2.5 feet?)
    BinaryImage newFilteredImage;
    int i = 0;
    int blobWeWant;
    int blobHeight;
    ParticleAnalysisReport newReport;
    
    Strafe strafe = new Strafe(-0.25);
    Strafe negStrafe = new Strafe( 0.25);
    

    public TestVision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        int i = 4;
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        i++;
        System.out.println("Execute testVision is running.");

        camera = AxisCamera.getInstance("10.23.99.11");
        cc = new CriteriaCollection();

        //cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 20, 400, false);
        //cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 15, 400, false);
        cc.addCriteria(MeasurementType.IMAQ_MT_AREA, 500, 65535, false);

        //will not work with a lower reolution( 120 x 140?). DO NOT CHANGE
        camera.writeResolution(AxisCamera.ResolutionT.k320x240);


        //if no delay, then AXIS CAMERA EXCEPTION!!!!
        //DO NOT REMOVE
        //only runs first time through execute
        if (foo) {
            //Timer.delay(5);
        }

        //Timer.delay(1);

        try {

            ColorImage image = camera.getImage();

            image.write("/newImage" + "d" + ".bmp");

            //BinaryImage thresholdImage = image.thresholdRGB(180, 255, 180, 250, 175, 255);   // keep only green objects
            //these values were not working in the light 

            BinaryImage thresholdImage = image.thresholdRGB(162, 255, 152, 255, 178, 255);    //testing these valus now...
            thresholdImage.write("/threshold" + "d" + ".bmp");
            BinaryImage convexHullImage = thresholdImage.convexHull(false);          // fill in occluded rectangles
            convexHullImage.write("/convexHull" + "d" + ".bmp");
            //BinaryImage noSmallParticles = convexHullImage.removeSmallObjects(true, 2);
            //noSmallParticles.write("/noSmallParticles.bmp");
            BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // filter out small particles
            filteredImage.write("/filteredImage" + "d" + ".bmp");
            newFilteredImage = convexHullImage.particleFilter(cc);


            //prints out the number of particles (red blobs) it sees after filtering
            //number of particles should be the number of targets in your viewing angle
            int numBlobs = filteredImage.getNumberParticles();

            System.out.println("Number of Particles: " + numBlobs + "\n" + "\n");

            //prints out information for each blob found
            for (int i = 0; i < numBlobs; i++) {
                ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
                /*System.out.println( //"Particle Analysis Report for " + i + " blob: " + report.toString() + "\n" + "\n" +
                        "Bounding Rectangle width for blob " + i + ": " + report.boundingRectWidth + "\n" + "\n"
                        + "Bounding Rectangle Height for blob " + i + ": " + report.boundingRectHeight + "\n" + "\n"
                        + //"Bounding Rectangle Area for blob " + i + ": "+ report.particleArea + "\n" + "\n" +
                        "Blob" + i + "center X: " + report.center_mass_x + "\n" + "\n"
                        + "Blob" + i + "center Y: " + report.center_mass_y + "\n" + "\n");

                System.out.println("blob " + i + " is a " + getTargetType(i) + "\n" + "\n");
                System.out.println("Distance 32.4: " + getDistance(i, (double)report.boundingRectWidth, 32.4) + "\n" + "\n");
                System.out.println("Distance 32.5: " + getDistance(i, (double)report.boundingRectWidth, 32.5) + "\n" + "\n");
                System.out.println("Distance 32.6: " + getDistance(i, (double)report.boundingRectWidth, 32.6) + "\n" + "\n");
                System.out.println("Distance 32.7: " + getDistance(i, (double)report.boundingRectWidth, 32.7) + "\n" + "\n");
                System.out.println("Distance 32.8: " + getDistance(i, (double)report.boundingRectWidth, 32.8) + "\n" + "\n");
                System.out.println("Distance 32.9: " + getDistance(i, (double)report.boundingRectWidth, 32.9) + "\n" + "\n");
                System.out.println("Distance 33.0: " + getDistance(i, (double)report.boundingRectWidth, 33.0) + "\n" + "\n");
                System.out.println("Distance 33.1: " + getDistance(i, (double)report.boundingRectWidth, 33.1) + "\n" + "\n");
                System.out.println("Distance 33.2: " + getDistance(i, (double)report.boundingRectWidth, 33.2) + "\n" + "\n");
                */
                if( i == 0){
                    blobWeWant = i;
                    blobHeight = report.boundingRectHeight;
                    newReport = filteredImage.getParticleAnalysisReport( blobWeWant);
                } else if( blobHeight < report.boundingRectHeight){
                    blobWeWant = i;
                    newReport = filteredImage.getParticleAnalysisReport(blobWeWant);
                }
            }
            
            //if to the right of target move left
            //if to the left of target move right
            //if in the center area, does not move
            if(newReport.center_mass_x  < 150){
                strafe.start();
            } else if( newReport.center_mass_x > 170){
                negStrafe.start();
            } 
            
            //Timer.delay( 1);
            

              


            //Always free every image you make!!!!

            image.free();
            thresholdImage.free();
            convexHullImage.free();
            filteredImage.free();

        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }

        //Timer.delay(0.5);
        foo = false;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //PAY ATTENTION TO THIS BOOLEAN
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    /**
     * 
     * @param particle the blob found in image processing
     * @return target type( Top, Middle)
     */
    String getTargetType(int particle) {

        String target = "not set";
        try {
            ParticleAnalysisReport report = newFilteredImage.getParticleAnalysisReport(particle);

            int blobWidth = report.boundingRectWidth;
            int blobHeight = report.boundingRectHeight;


            if (blobWidth / blobHeight > (topWidth / topHeight - 1) && blobWidth / blobHeight < (topWidth / topHeight + 1)) {
                target = "Top target";
            } else if (blobWidth / blobHeight > (middleWidth / middleHeight - 1) && blobWidth / blobHeight < (middleWidth / middleHeight + 1)) {
                target = "Middle Target";
            } else {
                target = "Not Top/Middle";
            }
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        return target;

    }
    /**
     * 
     * @param particleNumber the blob we want to use for distance calculations
     * @param pixelWidth the width of the specified blob
     * @param degrees the degrees of camera viewing angle
     * @return the distance from targets
     * 
     * Calculates the distance the robot is from targets
     */
    public double getDistance(int particleNumber, double pixelWidth, double degrees) {
        int targetWidth = 64;

        /*if( getTargetType(particleNumber).equals("Top target")){
        targetWidth = 64;
        
        } else if(getTargetType(particleNumber).equals("Middle Target")){
        targetWidth = 64;
        } else{
        targetWidth = 0;
        }*/

        double distance =
                ((320.0 * (64.0 / pixelWidth)) / 2.0) / Math.tan(degrees * (Math.PI / 180.0));
        return distance;
    }
  
}
