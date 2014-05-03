/**
 * Name:Paul A. Maddock
 * Class: MIT CS 100.01
 * Date: 4/3/14
 * Time: 10:16 PM
 * Project: MITProblem2
 */
public class Test {

    public static void main(String[] args){
        testLoop(1.2,2.3,4.5,6.4);

    }

    public static void testLoop(double... values){

        double count = 0;
        for (double value : values) {
            count += value;
        }
        System.out.print("Total Count is " + count);
    }
}
