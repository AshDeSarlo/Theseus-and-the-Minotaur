// Ash DeSarlo
// Theseus and the Minotaur
// COmputer Architecture Conference Project

import java.util.*;

public class TheseusAndTheMinotaur {
    
    player theseus;
    enemy minotaur;
    
    public static void main(String[] args) {
        TheseusAndTheMinotaur d = new TheseusAndTheMinotaur();
        d.TheseusAndTheMinotaur(5,10);
    }
        
    public void TheseusAndTheMinotaur(int x, int y) {
        player theseus = new player("Theseus", (x + 1)/2, 1, x, y, 1, 1);
        enemy minotaur = new enemy("Minotaur", (x + 1)/2, y, x, y, 1, 1);
        
        boolean gameOver = false;
        
        while (gameOver != true) {
            printGrid(x, y, theseus.getX(), theseus.getY(), minotaur.getX(), minotaur.getY());
            
            // Set up scanner to input player's command
            Scanner in = new Scanner(System.in);
            System.out.print("Your move? ");
            String move = in.nextLine();
            
            // Variable to easily increase the Minotaur's speed
            int mSpeed = 1;
            
            // Execute player's command and move the Minotaur
            if (move.equals("left")) {
                theseus.moveLeft(mSpeed);
                minotaur.moveRandomSmart(mSpeed, theseus);
            } else if (move.equals("right")) {
                theseus.moveRight(1);
                minotaur.moveRandomSmart(mSpeed, theseus);
            } else if (move.equals("up")) {
                theseus.moveUp(1);
                minotaur.moveRandomSmart(mSpeed, theseus);
            } else if (move.equals("down")) {
                theseus.moveDown(1);
                minotaur.moveRandomSmart(mSpeed, theseus);
            } else {
                System.out.println("Move not recognized, try again");
            }
            
            // Establish win/lose conditions
            
            if (theseus.getX() == minotaur.getX() &&
                theseus.getY() == minotaur.getY()) {
                
                printGrid(x, y, theseus.getX(), theseus.getY(), minotaur.getX(), minotaur.getY());
                System.out.println(" ");
                System.out.println("Oh no! The Minotaur caught you!");
                System.out.println("GAME OVER");
                gameOver = true;
                
            } else if (theseus.getX() == (x+1)/2 &&
                       theseus.getY() == y) {
                
                printGrid(x, y, theseus.getX(), theseus.getY(), minotaur.getX(), minotaur.getY());
                System.out.println(" ");
                System.out.println("You escaped the Labyrinth!");
                System.out.println("CONGRATULATIONS");
                gameOver = true;
            }
        }                                
    }
    
    // Print the grid, marking the exit with X
    public void printGrid(int x, int y, int tX, int tY, int mX, int mY) {
        
        String exitLine = "";
        for (int i = 1; i < x; i++) {
            if (i == (x+1)/2) {
                exitLine += " X ";
            } else {
                exitLine += "   ";
            }
        }
        
        System.out.println(exitLine);
        for (int i = y; i >= 1; i--) {
            String line = "";
            for (int j = 1; j <= x; j++) {
                if (mX == j && 
                    mY == i) {
                    line += " M ";
                } else if (tX == j && 
                           tY == i) {
                    line += " T ";
                } else {
                    line += " _ ";
                }
            }
            System.out.println(line);
        }
    }
                    
    
}