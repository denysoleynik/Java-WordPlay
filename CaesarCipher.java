import edu.duke.*;
import java.io.*;
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    
public String encrypt(String phrase, int key) {
    StringBuilder encrypted = new StringBuilder(phrase);
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String alphabetL = "abcdefghijklmnopqrstuvwxyz";
    String Newalphabet = alphabet.substring(key) + alphabet.substring(0, key);
    String NewalphabetL = alphabetL.substring(key) + alphabetL.substring(0, key);
    for (int i = 0; i < encrypted.length(); i++) {
        char currChar = encrypted.charAt(i);
        int id = alphabet.indexOf(currChar);
        if (id != -1) {
        char newChar = Newalphabet.charAt(id);
        encrypted.setCharAt(i, newChar);
        }
    }
    for (int i = 0; i < encrypted.length(); i++) {
        char currChar = encrypted.charAt(i);
        int id = alphabetL.indexOf(currChar);
        if (id != -1) {
        char newChar = NewalphabetL.charAt(id);
        encrypted.setCharAt(i, newChar);
        }
    }
    
    //System.out.println(encrypted);
    return encrypted.toString();
    }
    
public String encryptTwoKeys(String input, int key1, int key2) {
    //if (i %2 == 0);
    StringBuilder encrypted = new StringBuilder(input);
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String alphabetL = "abcdefghijklmnopqrstuvwxyz";
    String Newalphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
    String NewalphabetL1 = alphabetL.substring(key1) + alphabetL.substring(0, key1);
    String Newalphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
    String NewalphabetL2 = alphabetL.substring(key2) + alphabetL.substring(0, key2);
    for (int i = 0; i < encrypted.length(); i++) {
        char currChar = encrypted.charAt(i);
        int id = alphabet.indexOf(currChar);
        if (id != -1 && i%2 == 0) {
        char newChar = Newalphabet1.charAt(id);
        encrypted.setCharAt(i, newChar);
        }
        if (id != -1 && i%2 != 0) {
        char newChar = Newalphabet2.charAt(id);
        encrypted.setCharAt(i, newChar);
        }
    }
    for (int i = 0; i < encrypted.length(); i++) {
        char currChar = encrypted.charAt(i);
        int id = alphabetL.indexOf(currChar);
        if (id != -1 && i%2 == 0) {
        char newChar = NewalphabetL1.charAt(id);
        encrypted.setCharAt(i, newChar);
        }
        if (id != -1 && i%2 != 0) {
        char newChar = NewalphabetL2.charAt(id);
        encrypted.setCharAt(i, newChar);
        }
    }
    //System.out.println(encrypted);
    return encrypted.toString();
    }
    
    
public void testCaesar (){
//FileResource fr = new FileResource();
//String message = fr.asString();
String message = "Just a test string with lots of eeeeeeeeeeeeeeeees";
int key = 15;
String encrypted = encrypt(message, key);
System.out.println("Key is  " + key + "\n" + encrypted);
        
    }
    
    
public void testencryptTwoKeys() {
    encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21);
}
    
    

}
