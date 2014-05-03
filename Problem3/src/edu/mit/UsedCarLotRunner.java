package edu.mit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Name:Paul A. Maddock
 * Class: MIT CS 100.01
 * Date: 4/6/14
 * Time: 7:27 PM
 * Project: Problem3
 */
public class UsedCarLotRunner {
    public static void main(String[] args) {
        Car toyota = new Car("toyota");
        DriverRating tyDR = new DriverRating(1,3,2);
        toyota.setDriverRating(tyDR);
        toyota.setMpg(26);
        toyota.setPrice(18000);
        toyota.setYearsOld(0.5);
        Car honda = new Car("honda");
        DriverRating hDR = new DriverRating(6,1,2);
        honda.setDriverRating(hDR);
        honda.setMpg(25);
        honda.setPrice(20000);
        honda.setYearsOld(1);
        Car chevrolet = new Car("chevrolet");
        DriverRating chDR = new DriverRating(5,1,4);
        chevrolet.setDriverRating(chDR);
        chevrolet.setMpg(27);
        chevrolet.setPrice(17000);
        chevrolet.setYearsOld(1);
        Car bmw = new Car("bmw");
        DriverRating bDR = new DriverRating(3,0,1);
        bmw.setDriverRating(bDR);
        bmw.setMpg(23);
        bmw.setPrice(26000);
        bmw.setYearsOld(4);

        ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(toyota, honda, chevrolet, bmw));
        UsedCarLot ucl = new UsedCarLot(cars);
        System.out.println(ucl.getOverallRatings());
        System.out.println(ucl.getCarScores());
        for (Car car : ucl.getCars()){
            if (car.getName() == "chevrolet"){
                car.getDriverRating().addBadRatings(1);
                System.out.println("With " + 1 + " additional bad review, the updated overall score for Chevrolet " +
                        "is " + car.getScore());
            }
            if (car.getName() == "bmw"){
                car.getDriverRating().addGoodRatings(3);
                System.out.println("With " + 3 + " additional good review, the updated overall score for BMW " +
                        "is " + car.getScore());
            }
        }

        System.out.println("\nCars in lot newer than one year:");
        for (Car car : ucl.getCars()){
            if (car.getYearsOld() < 1){
                System.out.println(car.getName());
            }
        }

        System.out.println("\nPercent of bad ratings:");
        for (Car car : ucl.getCars()){
            double percentBad = ((double)(car.getDriverRating().getNumBadRatings())/car.getDriverRating().getTotalNumRatings())*100;
            System.out.println(car.getName() + ": " + String.valueOf(percentBad));
        }
    }
}
