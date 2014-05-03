package edu.mit;


/**
 * Name:Paul A. Maddock
 * Class: MIT CS 100.01
 * Date: 4/6/14
 * Time: 7:24 PM
 * Project: Problem3
 */
public class Car {

    private DriverRating driverRating;
    private double price = 0;
    private double yearsOld = 0;
    private double mpg = 0;
    private String name;

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setYearsOld(double yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public double getPrice() {
        return price;
    }

    public double getYearsOld() {
        return yearsOld;
    }

    public double getMpg() {
        return mpg;
    }

    public Car(String name){
        this.name =name;
    }
    public DriverRating getDriverRating() {
        return this.driverRating;
    }
    public void setDriverRating(DriverRating dr) {
        driverRating = dr;
    }
    public double getScore(){
        assert this.driverRating instanceof DriverRating;
        return (26000 - this.price)/3000 - .2*(this.yearsOld) + .2*(this.mpg-25) + this.driverRating.getDriverRating();
    }
}
