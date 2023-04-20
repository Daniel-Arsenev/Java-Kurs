import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class BullsAndCowsGame {

    // class that stores the number of Bulls and Cows a Player got on a round
    static class BullsAndCows {
        public int Bulls;
        public int Cows;
    }

    static String[] allWords = new String[4970];

    // Läd die Wörter aus der Datei words.txt in das Array allWords
    static void loadWords() {
        try {
            // Scanner der die Datei words.txt liest
            File wordsFile = new File("words.txt");
            Scanner scanner = new Scanner(wordsFile);

            // Zählschleife von 0 bis zur der Anzahl der Wörter in word.txt
            // Variable i ist der index des Wortes, das gescannt wird
            for (int i = 0; i < 4970; i++){
                // Speichern des Wortes aus der Datei in das Array
                allWords[i] = scanner.next();
            }

            scanner.close();
        }
        // Falls Die Datei nicht gefunden wird bende das Programm
        catch (FileNotFoundException ex) {
            System.out.println("Datei nicht gefunden");
            System.exit(1);
        }

    }

    static BullsAndCows calcBullsAndCows(String targetWord, String guessedWord){
        BullsAndCows ret = new BullsAndCows();

        // Iteriere durch die Wörter und vergleiche die Buchstaben an index i
        // Falls sie gleich sind, addieren wir 1 zu Bulls
        for (int i = 0; i < targetWord.length(); i++){
            if (targetWord.charAt(i) == guessedWord.charAt(i)){
                ret.Bulls++;
            }
            // Anderenfalls suchen wir, ob sich der Buchstabe in target Wort befindet
            // Und falls ja, addieren wir 1 zu Cows
            else {
                for (int j = 0; j < targetWord.length(); j++){
                    if (targetWord.charAt(j) == guessedWord.charAt(i)){
                        ret.Cows++;
                        break;
                    }
                }
            }
        }

        return ret;
    }

    static void playGame(){
        // Wählen zufälligen Wortes aus der Liste
        int randomIndex = (int) Math.ceil(Math.random() * 4970.0);
        String targetWord = allWords[randomIndex];

        System.out.println("DEBUG: Wort ist: " + targetWord);
        System.out.println("Das Wort hat " + targetWord.length() + " Buchstaben \n");
        Scanner scanner = new Scanner(System.in);


        for (int tries = 0; tries < targetWord.length() * 2; tries++) {

            // Nehme Wörter auf, bis es die selbe Länge wie das wie das geheime Wort hat
            String guessedWord;
            do {
                
                System.out.print("Versuch " + (tries + 1) + ": ");
                guessedWord = scanner.next();

            } while (guessedWord.length() != targetWord.length()); 


            // berrechne die Anzahl and Bulls and Cows
            BullsAndCows Result = BullsAndCowsGame.calcBullsAndCows(targetWord, guessedWord);


            // Win condition ist es alle Buchstaben richtig zu haben
            // Das beudetet so viele Bulls zu haben wie das Wort Buchstaben hat
            if (Result.Bulls == targetWord.length()){
                System.out.println("Du hast das richtige Wort!");
                return;
            }
            // Falls nicht gewonnen, gebe Bulls und Cows aus
            else {
                System.out.println(Result.Bulls + " Bulls and " + Result.Cows + " Cows");
            }
        }

        System.out.println("Zu Schade! Das Wort wäre '" + targetWord + "' gewesen");
    }

    public static void main(String[] args) {
        loadWords();
        playGame();
    }
}