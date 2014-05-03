package edu.mit;

/**
 * Name:Paul A. Maddock
 * Class: MIT CS 100.01
 * Date: 4/6/14
 * Time: 7:24 PM
 * Project: MITProblem3
 */
public class DriverRating {
    private int numGoodRatings = 0;
    private int numOkayRatings = 0;
    private int numBadRatings = 0;

    public DriverRating(int good, int bad, int okay){
        numGoodRatings = good;
        numBadRatings = bad;
        numOkayRatings = okay;
    }

    public void setNumGoodRatings(int numGoodRatings) {
        this.numGoodRatings = numGoodRatings;
    }
    public void setNumOkayRatings(int numOkayRatings ) {
        this.numOkayRatings = numOkayRatings;
    }
    public void setNumBadRatings(int numBadRatings ) {
        this.numBadRatings = numBadRatings;
    }
    public int getNumGoodRatings() {
        return this.numGoodRatings;
    }
    public int getNumOkayRatings() {
        return this.numOkayRatings;
    }
    public int getNumBadRatings() {
        return this.numBadRatings;
    }
    public void addBadRatings(int num){
        numBadRatings += num;
    }
    public void addGoodRatings(int num){
        numGoodRatings += num;
    }
    public void addOkayRatings(int num){
        numOkayRatings += num;
    }
    public int getTotalNumRatings() {
        return this.numBadRatings + this.numOkayRatings + this.numGoodRatings;
    }
    public double getDriverRating(){
        return (this.numGoodRatings +(.5*this.numOkayRatings) - this.numBadRatings)/this.getTotalNumRatings();
    }

}
