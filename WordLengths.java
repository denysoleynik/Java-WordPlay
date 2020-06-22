import edu.duke.*;
import java.io.*;
/**
 * Write a description of class WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {

public int[] countWordLengths(FileResource resource, int[] counts) {
    for (String word : resource.words()) {
            word = word.toLowerCase();
            int letterCount = 0;
            for (int index=0; index < word.length(); index++) {
                if ((index == 0 || index == (word.length()-1)) && 
                    !Character.isLetter(word.charAt(index))) {
                    continue;
                }
                letterCount++;
            }
            if (letterCount >= counts.length) {
                counts[counts.length] += 1;
            }
            else {
                counts[letterCount] += 1;
            }
        }
        return counts;
    }
    
 public int indexOfMax(int[] counts)    {
    int indexmax = 0;
    int commonl = 0;
    for (int i=1; i<counts.length; i++) {
        int currindex = counts[i];
        if (currindex>indexmax) {
            indexmax = i;
            commonl = counts[i];
        }
    }
    return commonl;
}
    



            public void testCountWordLengths() {
        FileResource fileResource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fileResource, counts);
        for (int k=1; k < counts.length; k++) {
            System.out.println("Number of " + k + "-letter words\t" + counts[k]);
        }
        System.out.println("Most common word length is " + indexOfMax(counts) +
                                " letters");
   
}
}


