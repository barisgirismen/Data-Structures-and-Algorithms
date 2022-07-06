package project3_1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Barış Girişmen (19COMP1024)
 */
public class Password {
        
    public static void checkPassword(boolean goodPassword) throws IOException {
        Scanner input = new Scanner(System.in);
                
        /*Pattern pattern = Pattern.compile(
        "(?i)" +  //Makes it match case insensitive
        "{5,}" +  //At least 5 digits long
        "(?=.*[A-Z])" +  //At least one upper case character (A-Z)
        "(?=.*[a-z])" +     //At least one lower case character (a-z)
        "(?=.*\\d)" +   //At least one digit (0-9)
        "(?=.*\\p{Punct})" +  //At least one special character (Punctuation)
        "^[^\\d]" + // Password should not start with a digit
        ".*" +
        "[a-zA-Z\\d]$");   // Password should not end with a special character
        Matcher matcher = pattern.matcher("1Sz1");*/
        
        FileInputStream words = new FileInputStream("words.txt");
        FileInputStream passwords = new FileInputStream("passwords.txt");
        SequenceInputStream dictionary = new SequenceInputStream(words, passwords);
        BufferedReader reader = new BufferedReader(new InputStreamReader(dictionary));
        
        String compileInput = input.next();  
        Pattern wordsPattern = Pattern.compile("(?i)" + "{5,}" + compileInput + "(\\b)");
        
        String line;
        int matchCount = 0;
        
        while ( (line = reader.readLine()) != null) {            
            Matcher wordsMatcher = wordsPattern.matcher(line);
            while (wordsMatcher.find()) {
                matchCount++;
            }
        }
        
        if (matchCount > 0){
            goodPassword = false;
            System.out.println("Word was found!");
        } else {
            goodPassword = true;
            System.out.println("Word was not found!");
        }
    }

    public static void options(){
        Scanner input = new Scanner(System.in);
        System.out.print("\n═══════════════════════════════════════════════════\n\n"
        + "Type 1 to try again, 2 to display the conditions or 0 to exit: ");
                                
        String option = input.next();
        switch(option){
            case "0":
                System.exit(0);
            case "1":
                break;
            case "2":
                System.out.println("\nA good password means that it is\n"
                + "↪ at least 5 characters long,\n"
                + "↪ not a word in the english dictionary or mostly used password dictionary,\n"
                + "↪ not a word in the dictionary followed/prefixed by a digit 0-9 (e.g. hello5, 5hello).");
                break;
            default:
                System.out.println("\nWrong option.");
                options();
                break;
        }
    }
}