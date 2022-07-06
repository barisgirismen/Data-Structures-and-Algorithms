package project3_1;

import java.io.IOException;

/**
 *
 * @author Barış Girişmen (19COMP1024)
 */
public class TestClass {
    
    public static void main(String[] args) throws IOException {
            
        //The "words.txt" consists of 1.164.012 Turkish and 466.550 English words. It has 1.630.562 words in total.
        //I put words from both languages in the same file and sorted them alphabetically.
        //Source for Turkish words: https://raw.githubusercontent.com/ncarkaci/TDKDictionaryCrawler/master/Birle%C5%9Ftirilmi%C5%9F_S%C3%B6zl%C3%BCk_Kelime_Listesi.txt        
        //Source for English words: https://raw.githubusercontent.com/dwyl/english-words/master/words.txt
           
        System.out.println("Welcome to Işık Password Checker! 🔑\n\n"
                + "This program checks whether your password is a good one or not.\n\n"
                + "A good password means that it is\n"
                + "↪ at least 5 characters long,\n"
                + "↪ not a word in the english dictionary or mostly used password dictionary,\n"
                + "↪ not a word in the dictionary followed/prefixed by a digit 0-9 (e.g. hello5, 5hello).");

        boolean goodPassword = true;
        
        while (true) {
            System.out.print("\nEnter your password: ");
            Password.checkPassword(goodPassword);

            if (goodPassword == true){
                System.out.print("Your password is a good one! ✓\n");
                Password.options();
            } else {
                System.out.print("Your password is not good enough. ✘\n");
                Password.options();
            }
        }  
    }
}