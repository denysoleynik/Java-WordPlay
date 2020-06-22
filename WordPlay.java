import edu.duke.*;
import java.io.*;

/**
 * Write a description of class First here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {

public boolean isVowel(char ch) {
    if (ch == 'a' || ch == 'o' || ch == 'e' || ch == 'i' || ch == 'u' || ch == 'A' || ch == 'O' || ch == 'E' || ch == 'I' || ch == 'U') {
    //System.out.println("true");
        return true;
    }
    //System.out.println("false");
    return false;
}

public String replaceVowels(String phrase, char ch) {
    StringBuilder replaced = new StringBuilder(phrase);
    for (int i = 0; i < replaced.length(); i++) {
        char currChar = replaced.charAt(i);
        if (isVowel(currChar)) {
            replaced.setCharAt(i, ch);
        }
        
    }
    String Final = replaced.toString();
    System.out.println(Final);
    return Final;
}

public String emphasize(String phrase, char ch) {
    StringBuilder replaced = new StringBuilder(phrase);
    for (int i = 0; i < replaced.length(); i++) {
        char currChar = replaced.charAt(i);
        if (currChar == ch || currChar == Character.toUpperCase(ch) ||  currChar == Character.toLowerCase(ch)) {
            if (i %2 == 0) {
                replaced.setCharAt(i, '*');
           }
           else  {
                replaced.setCharAt(i, '+');
           }
        
        }
    }
    String Final = replaced.toString();
    System.out.println(Final);
    return Final;
}



public void TEST() {
    emphasize("Mary Bella Abracadabra", 'a');
}

public void TESTreplaceVowels() {
    replaceVowels("Hello World", '*');
}


}
