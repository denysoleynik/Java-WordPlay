import edu.duke.*;
import java.io.*;
import java.util.Random;

/**
 * Write a description of class Dices here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dices {
 public void simpleSimulate(int rolls) {
 Random rand = new Random();
 int[] counts =  new int [13];
 
 for (int k=0; k < rolls; k++) {
 int d1 = rand.nextInt(6) + 1;
 int d2 = rand.nextInt(6) + 1;
 counts[d1+d2] += 1;
 }
 
 for (int k = 2; k <=12; k++) {
      System.out.println(k + " count is " + counts[k] + " with percentage " + 100.0 * counts[k]/rolls);
    }

     
    }


public void testRolls () {
    simpleSimulate(1000);
}
}
