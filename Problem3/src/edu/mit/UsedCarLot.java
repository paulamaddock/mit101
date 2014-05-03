package edu.mit;

import java.util.ArrayList;

/**
 * Name:Paul A. Maddock
 * Class: MIT CS 100.01
 * Date: 4/6/14
 * Time: 7:24 PM
 * Project: Problem3
 */
public class UsedCarLot {
    ArrayList<Car> cars ;

    public UsedCarLot(ArrayList<Car> cars){
        this.cars = cars;
    }

    public UsedCarLot(){
    }

    public void addCar(Car car){
        this.cars.add(car);
    }
    public void removeCar(int i){
        this.cars.remove(i);
    }
    public String getCarScores(){
        String scoreReport = "";
        scoreReport += "Overall scores:\n";
        for(Car car : this.cars) {
            scoreReport += car.getName() + ": " + car.getScore() +  "\n";
        }
        return scoreReport;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public String getOverallRatings(){
        String ratingReport = "";
        ratingReport += "Over all ratings:\n";
        for(Car car : this.cars) {
            ratingReport += car.getName() + ": " + car.getDriverRating().getDriverRating() +  "\n";
        }
        return ratingReport;
    }

}
