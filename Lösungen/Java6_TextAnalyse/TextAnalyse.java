import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class TextAnalyse {

    // class that stores the number of Bulls and Cows a Player got on a round
    static class Letter {
        public char character;
        public int count;
    }

    static String[] allWords = new String[4970];
    static Letter[] letters = new Letter[26];

    // Läd die Wörter aus der Datei words.txt in das Array allWords
    static void loadWords() {
        try {
            // Scanner der die Datei words.txt liest
            File wordsFile = new File("words.txt");
            Scanner scanner = new Scanner(wordsFile);

            // Zählschleife von 0 bis zur der Anzahl der Wörter in word.txt
            // Variable i ist der index des Wortes, das gescannt wird
            for (int i = 0; i < 2500; i++){
                // Speichern des Wortes aus der Datei in das Array
                allWords[i] = scanner.next().toLowerCase();
            }

            scanner.close();
        }
        // Falls Die Datei nicht gefunden wird bende das Programm
        catch (FileNotFoundException ex) {
            System.out.println("Datei nicht gefunden");
            System.exit(1);
        }

    }


    static void loadLetters(){
        for (int i = 0; i < 26; i++) {
            Letter letter = new Letter();

            // conversion from int into char. a is 97
            char character = (char) (i + 97);
            letter.character = character; 

            letters[i] = letter;
        }
    }

    static void countAllLetters(){
        for (int i = 0; i < 2500; i++){
            countLetters(allWords[i]);
        }
    }

 
    static void countLetters(String word) {
        char[] chararray = word.toCharArray();
        // loop over the letters of the word
        for (int i = 0; i < word.length(); i++) {
            // loop over the letters in the letters array
            for (int j = 0; j < 26; j++){
                // if they are equal increase the count by one
                if (letters[j].character == chararray[i]){
                    letters[j].count++;
                    break;
                }
            }
        }
    }

    static void selectionSortLetters(){
        for (int i = 0; i < 26; i++) {
            int maxindex = i;
            
            // search for the letter in the unsorted list with the highest count
            for (int j = i; j < 26; j++){
                if (letters[maxindex].count < letters[j].count){
                    maxindex = j;
                }
            }

            // swap it to the front
            Letter temp = letters[maxindex];
            letters[maxindex] = letters[i];
            letters[i] = temp;


        }
    }

    static void printLetters(){
        for (int i = 0; i < 26; i++){
            System.out.println(letters[i].character + " " + letters[i].count);
        }
    }

    public static void main(String[] args) {
        loadWords();
        loadLetters();
        countAllLetters();
        selectionSortLetters();
        printLetters();
    }
}