import javax.swing.*;
import java.util.Random;
import java.awt.*;



public class SchiffeVersenken {

    // the playing field
    //  > false if the field cell is empty
    //  > true  if the field cells contains a ship piece
    public static boolean[][] Field = new boolean[10][10];

    public static int shootsLeft = 60;
    public static int hits = 0;


    // tries to modify the field by putting a ship into it
    // returns false if it has failed to place the Ship, because it was obstructed
    public static boolean TryToPlace(int ShipLength){
        boolean dir =  new Random().nextBoolean();

        // ship is either placed horizontally
        if (dir) {
            int x = new Random().nextInt(0, 10 - ShipLength);
            int y = new Random().nextInt(0, 10);

            for (int i = 0; i < ShipLength; i++) {
                if (Field[x + i][y] == true){
                    return false;
                }
            }

            for (int i = 0; i < ShipLength; i++) {
                Field[x + i][y] = true;
            }

            return true;

        }
        // or it is placed vertically
        else {
            int x = new Random().nextInt(0, 10);
            int y = new Random().nextInt(0, 10 - ShipLength);

            for (int i = 0; i < ShipLength; i++) {
                if (Field[x][y + i] == true) {
                    return false;
                }
            }

            for (int i = 0; i < ShipLength; i++) {
                Field[x][y + i] = true;
            }

            return true;
        }
    }


    public static void populateField() {
        int retries = 0;

        int[] shipsToPlace = {5, 4, 4, 3, 3, 3, 2, 2, 2, 2};
        for (int i = 0; i < shipsToPlace.length; i++){
            int ship = shipsToPlace[i];

            while (true) {
                // if we succeed in placing, we try to place the next
                if (TryToPlace(ship) == true) {
                    break;
                }

                // if we has to retry more than 100 times, 
                // we assume that it is impossible to fit
                // and restart completely
                if (retries++ > 100) {
                    Field = new boolean[10][10];
                    i = 0; retries = 0; 
                    break;
                }
            }
        }
    }


    public static void createGame(){
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setResizable(false);


        JTextField Output = new JTextField();
        Output.setEditable(false);
        Output.setText("Shots left: 60");
        frame.add(Output, BorderLayout.PAGE_END);


        JPanel buttonField = new JPanel();
        buttonField.setLayout(new GridLayout(10, 10));
        frame.add(buttonField);

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                final int buttonX = x;   // final means const
                final int buttonY = y;   // final means const

                JButton button = new JButton();
                buttonField.add(button);
                button.addActionListener(event -> {
                    if (shootsLeft > 0 && (button.getBackground() != Color.RED && button.getBackground() != Color.CYAN)) {

                        Output.setText("Shots left: " + --shootsLeft);
                        hits += Field[buttonX][buttonY] ? 1 : 0;

                        button.setBackground(Field[buttonX][buttonY] ? Color.RED : Color.CYAN);
                    }

                    if (hits == 30) {
                        Output.setText("YOU WON");
                    }
                    else if (shootsLeft == 0) {
                        Output.setText("YOU LOST");
                    }

                });
            }
        }




        frame.setVisible(true);
    }



    public static void main(String[] args) {
        populateField();
        createGame();
    }

}



