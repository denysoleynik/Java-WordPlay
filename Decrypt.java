import edu.duke.*;
import java.io.*;

/**
 * Write a description of class Decrypt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Decrypt {
    
    public String[] getCommon() {
    FileResource resource = new FileResource("common20.txt");
    String[] common = new String[20];
    int index = 0;
    for (String s : resource.words()) {
        common[index] = s;
        index +=1;
    }
    return common;
}

public int index(String[] list, String word) {
    for ( int k=0; k < list.length; k++) {
        if (list[k].equals(word)) {
            return k;
    }
   }
   return -1;
}

public void countWords (FileResource resource, String[] common, int[] counts) {
    for (String word : resource.words()) {
        word = word.toLowerCase();
        int index = index(common,word);
        if (index != -1) {
            counts[index] += 1;           
        }                
    }
}

public void countSheakspir() {
    String[] texts = {"caesar.txt", "errors.txt", "hamlet.txt"};
    String[] common = getCommon();
    int[] counts = new int[common.length];
    for (int k=0; k < texts.length; k++) {
        FileResource resource = new FileResource(texts[k]);
        countWords(resource,common,counts);
        System.out.println("done with " + texts[k]);
    }
    for (int k=0; k < common.length; k++) {
        System.out.println(common[k] + " counted " + counts[k]);
    }
}



}








