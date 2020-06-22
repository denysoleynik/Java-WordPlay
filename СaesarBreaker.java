import edu.duke.*;
import java.io.*;
/**
 * Write a description of class DecryptbyLetter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class СaesarBreaker {
    
public String halfOfString(String message, int start) {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<message.length(); i++)
    {
    if (start % 2 == 0 && i%2 == 0) {
    char curr1 = message.charAt(i);
    sb.append(curr1);
     }
     if (start % 2 != 0 && i%2 != 0) {
     char curr1 = message.charAt(i);
     sb.append(curr1);
     }

     }
        String half = sb.toString();
        return half;
}

public int getkey(String message) {
    int[] numbers = counts(message);
    int maxindex = findkey(numbers);
    return maxindex;
}

public String decryptTwoKeys(String encrypted) {
    String First = halfOfString(encrypted, 0);
    String Second = halfOfString(encrypted, 1);
    int getkey1 = getkey(First);
    System.out.println(getkey1);
    int getkey2 = getkey(Second);
    System.out.println(getkey2);
    String Final = decrypt2(encrypted, getkey1, getkey2);
    System.out.println(Final);
    return Final;   
}


public int[] counts(String message) {
    String alph = "abcdefghijklmnopqrstuvwxyz";
    int[] countS = new int[26];
    for (int i = 0; i < message.length(); i++) {
        char ch = Character.toLowerCase(message.charAt(i));
        int dex = alph.indexOf(ch);
        if (dex != -1) {
        countS[dex] += 1;
        //System.out.println(countS[dex]);
        }
    }      
    return countS;
    
}


public int findkey(int[] vals) {
        
        int indOfMax = 0;
        int maxSoFar = vals[0];
        
        for (int i=1;i<vals.length;i++){
        
            if (vals[i]>maxSoFar) {
                maxSoFar = vals[i];
                indOfMax = i;
                //System.out.println(indOfMax);
            }
        }
        //System.out.println(indOfMax);
        return indOfMax;
    }

public String decrypt(String message, int key) {
    CaesarCipher cc = new CaesarCipher();
    int[] freqs = counts(message);
    int maxDex = findkey(freqs);
    int dkey = key - 4;
    //System.out.println(dkey);
    if (key < 4) {
     dkey = 26 - (4-key);
    }
    String Final = cc.encrypt(message,26 - dkey);
      //System.out.println(Final);
    return Final;
    }
    
 public String decrypt2(String message, int key1, int key2) {
    CaesarCipher cc = new CaesarCipher();
    //int[] freqs = counts(message);
    //int maxDex = findkey(freqs);
    int dkey1 = key1 - 4;
    int dkey2 = key2 - 4;
    //System.out.println(dkey);
    if (key1 < 4) {
     dkey1 = 26 - (4-key1);
    }
    if (key2 < 4) {
     dkey2 = 26 - (4-key2);
    }
    System.out.println("First Key is " + (26 - dkey1) + " Second Key is " + (26 - dkey2));
    String Final = cc.encryptTwoKeys(message, 24, 6);
    //System.out.println(Final);
    return Final;
    }
        
    public void testDecrypt(){
        String message = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        CaesarCipher cc = new CaesarCipher();
        String encrypted = cc.encrypt(message,15);
        System.out.println(encrypted);
        System.out.println(decrypt(encrypted,25));       
}

 public void testhalfOfString(){
       String message = "Qbkm Zgis";
       int start = 1;
       String execute = halfOfString(message, start);
       System.out.println(execute);
}

public void testDecryptTwoKeys(){
      //FileResource fr = new FileResource();   
       String test = "Top ncmy qkff vi vguv vbg ycpx";
       //decryptTwoKeys(test);
       System.out.println(decryptTwoKeys(test));
       //System.out.println("the key is: " );
       
}
}


