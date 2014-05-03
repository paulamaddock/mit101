package com.paul;

import java.util.ArrayList;

/**
 * Name:Paul A. Maddock
 * Class: MIT CS 100.01
 * Date: 4/10/14
 * Time: 10:40 PM
 * Project: Problem4
 */
public class Dictionary {
    String[] twoLetterWords = {"AA","AB","AD","AE","AG","AH","AI","AL","AM","AN","AR","AS","AT","AW","AX","AY","BA","BE","BI","BO","BY","DE","DO","ED","EF","EH","EL","EM","EN","ER","ES","ET","EX","FA","FE","GO","HA","HE","HI","HM","HO","ID","IF","IN","IS","IT","JO","KA","KI","LA","LI","LO","MA","ME","MI","MM","MO","MU","MY","NA","NE","NO","NU","OD","OE","OF","OH","OI","OM","ON","OP","OR","OS","OW","OX","OY","PA","PE","PI","QI","RE","SH","SI","SO","TA","TI","TO","UH","UM","UN","UP","US","UT","WE","WO","XI","XU","YA","YE","YO","ZA"};
    ArrayList<ArrayList<String>> threeLetterWords = new ArrayList<ArrayList<String>>();
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public Dictionary() {
    }

    public void addLetterSet(ArrayList<String> letterSet){
       threeLetterWords.add(letterSet);
    }
    public void setTwoLetterWords(String[] twoLetterWords) {
        this.twoLetterWords = twoLetterWords;
    }

    public String[] getTwoLetterWords(String set) {
        return twoLetterWords;
    }

    public ArrayList<String> getThreeLetterWordSetFromHand(String hand){
        ArrayList<String> matches= new ArrayList<String>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        Boolean searched = false;
        Boolean existsAlready = false;
        //loop through hand
        for (Integer i = 0; i < hand.length(); i++){
            //loop through alphabet
            for (int j = 0; j < threeLetterWords.size()-1; j++){
                //skip letters that have been explored already
                searched = false;
                for (int index : indexes){
                    if (j == index){
                        searched = true;
                        break;
                    }
                }

                if (threeLetterWords.get(j).size() >0){
                    if (!searched && hand.charAt(i) == threeLetterWords.get(j).get(0).charAt(0)){
                            indexes.add(j);
                            //loop through words at letter
                            for (String word : threeLetterWords.get(j)){
                                for (String match : matches){
                                    if (word == match){
                                        existsAlready = true;
                                    }
                                }
                                if (!existsAlready){
                                    for (int l = 0; l < hand.length(); l++) {
                                        if (l != i && hand.charAt(l) == word.charAt(1)){
                                            for(int k = 0; k < hand.length(); k++){
                                                if (k != l && k != i && hand.charAt(k) == word.charAt(2)){
                                                    matches.add(word);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        return matches;
    }

    public ArrayList<String> getTwoLetterWordsSetFromHand(String hand){
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        ArrayList<String> matches = new ArrayList<String>();
        Boolean existsAlready;
        //loop through hand
        for (int i = 0; i < hand.length(); i++){
            for (String word : twoLetterWords){
                existsAlready = false;
                for (String match : matches){
                   if (word == match){
                       existsAlready = true;
                   }
                }
                if (word.charAt(0) == hand.charAt(i) && !existsAlready){
                    for (int k = 0; k < hand.length(); k++){
                        if (i != k && word.charAt(1) == hand.charAt(k) ){
                            matches.add(word);
                            break;
                        }
                    }
                }
            }
        }
        return matches;
    }
    public ArrayList<ArrayList<String>> getThreeLetterWords() {
        return threeLetterWords ;
    }
    public void findWords(String letters, int number){

    }
}
