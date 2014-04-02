/**
 * Created by paulmaddock on 3/30/14.
 */
public class Throw {
    /**
     * Your program should prompt the user for the following inputs:
     *- distance,d, from thrower’s hand to the center of the basket (in meters)
     *- diameter of the basket (in meters)
     *- initial ball speed v0(in meters/second)
     *- height of the ceiling from the basket (in meters)
     */

    final double GRAV = 9.8;
    double distance;
    double diameter;
    double initSpeed;
    double heightOfCeiling;
    double ceilingHeight;

    public Throw(double distance, double diameter, double initSpeed, double heightOfCeiling) {
        this.distance = distance;
        this.diameter = diameter;
        this.initSpeed = initSpeed;
        this.heightOfCeiling = heightOfCeiling;
    }

    public double computeOptimalAngle(){
        return Math.asin(( distance * GRAV ) / Math.pow(initSpeed, 2))/2;
    }

    public double computeSmallestAngle(){
        return Math.asin(( distance - (diameter/2) * GRAV ) / Math.pow(initSpeed, 2))/2;
    }

    public double computeLargestAngle(){
        return Math.asin(( distance + (diameter/2) * GRAV ) / Math.pow(initSpeed, 2))/2;
    }

    public boolean hitsCeiling(){
        // sin2x = 1/2 - 1/2 cos(2x)
        return ceilingHeight <= this.computeHeight();
    }
    public double computeHeight(){
        return (initSpeed * (1/2 - 1/2 * Math.cos(this.computeOptimalAngle())))/2*GRAV;
    }
}
