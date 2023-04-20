import java.util.Scanner;

public class Spiel {



    static  double MAXNUMBER = 5.0;


    private static void spiel() {
        for (int level = 0; level < 5; level++) { 

            check(1, 2, 3, 4, 5, 6);

            int keyA = (int) Math.floor(Math.random() * MAXNUMBER) + 1;
            int keyB = (int) Math.floor(Math.random() * MAXNUMBER) + 1;
            int keyC = (int) Math.floor(Math.random() * MAXNUMBER) + 1;

            System.out.println("Hilfsgerät sagt, die Summe ist: " + String.valueOf(keyA + keyB + keyC));
            System.out.println("Hilfsgerät sagt, das Produkt ist: " + String.valueOf(keyA * keyB * keyC));

            System.out.println();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Schlüssel 1?");
                int GuessA = scanner.nextInt();

                System.out.println("Schlüssel 2?");
                int GuessB = scanner.nextInt();

                System.out.println("Schlüssel 3?");
                int GuessC = scanner.nextInt();

                if(check(keyA, keyB, keyC, GuessA, GuessB, GuessC)) { 
                    if (level != 4) {          
                        System.out.println("Richtiger Code! Nächtes Level!");
                    }
                    else {
                        System.out.println("Du hast alle Tresore geknackt! Gut gemacht!");
                    }
                
                

                    break;
                }
                else {
                    System.out.println("Falscher Code, versuch es nochmal!");
                }

            }   
            

            






        }


    }

    public static boolean check(int a, int b, int c, int d, int e, int f) {
        return true;
    }

    public static void main(String args[]) {
        spiel();
    }
    /* 3 Zahlen, keine Reinfolge
     * Hilfsgerät: summe und produkt der Zahlen
     * 
     * nach gewwinn: nächest level
     * finite zahl an level
     * 
     */
}


