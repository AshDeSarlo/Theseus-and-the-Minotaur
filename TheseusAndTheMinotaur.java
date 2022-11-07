// Ash DeSarlo
// Theseus and the Minotaur
// COmputer Architecture Conference Project

import java.util.*;

public class TheseusAndTheMinotaur {
    
    
    public static void main(String[] args) {
        TheseusAndTheMinotaur d = new TheseusAndTheMinotaur();
        d.TheseusAndTheMinotaur(5,10);
    }
        
    public void TheseusAndTheMinotaur(int x, int y) {
        Labyrinth l = new Labyrinth(x, y);
        
        boolean gameOver = false;
        
        while (gameOver != true) {
            l.updatePanel();
            System.out.println("theseus: " + l.theseus.getX() + " , " + l.theseus.getY());
            System.out.println("Minotaur: " + l.minotaur.getX() + " , " + l.minotaur.getY());
            
            // Set up scanner to input player's command
            Scanner in = new Scanner(System.in);
            System.out.print("Your move? ");
            String move = in.nextLine();
            
            // Variable to easily increase the Minotaur's speed
            int mSpeed = 1;
            
            // Execute player's command and move the Minotaur
            if (move.equals("left")) {
                l.theseus.moveLeft(mSpeed);
                l.minotaur.moveRandomSmart(mSpeed, l.theseus);
            } else if (move.equals("right")) {
                l.theseus.moveRight(1);
                l.minotaur.moveRandomSmart(mSpeed, l.theseus);
            } else if (move.equals("up")) {
                l.theseus.moveUp(1);
                l.minotaur.moveRandomSmart(mSpeed, l.theseus);
            } else if (move.equals("down")) {
                l.theseus.moveDown(1);
                l.minotaur.moveRandomSmart(mSpeed, l.theseus);
            } else {
                System.out.println("Move not recognized, try again");
            }
            
            l.updatePanel();
            
            // Establish win/lose conditions
            
            if (l.theseus.getX() == l.minotaur.getX() &&
                l.theseus.getY() == l.minotaur.getY()) {
                l.updatePanel();
                System.out.println(" ");
                System.out.println("Oh no! The Minotaur caught you!");
                System.out.println("GAME OVER");
                gameOver = true;
                
            } else if (l.theseus.getX() == (x+1)/2 &&
                       l.theseus.getY() == y) {
                l.updatePanel();
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

// ----------------------------------------------------------------------------------------
// LEGACY CODE -- PRINTGRID VERSION
// ----------------------------------------------------------------------------------------

//public void TheseusAndTheMinotaur(int x, int y) {
//        player l.theseus = new player("Theseus", (x + 1)/2, 1, x, y, 1, 1);
//        enemy l.minotaur = new enemy("Minotaur", (x + 1)/2, y, x, y, 1, 1);
//        
//        boolean gameOver = false;
//        
//        while (gameOver != true) {
//            printGrid(x, y, l.theseus.getX(), l.theseus.getY(), l.minotaur.getX(), l.minotaur.getY());
//            
//            // Set up scanner to input player's command
//            Scanner in = new Scanner(System.in);
//            System.out.print("Your move? ");
//            String move = in.nextLine();
//            
//            // Variable to easily increase the Minotaur's speed
//            int mSpeed = 1;
//            
//            // Execute player's command and move the Minotaur
//            if (move.equals("left")) {
//                l.theseus.moveLeft(mSpeed);
//                l.minotaur.moveRandomSmart(mSpeed, l.theseus);
//            } else if (move.equals("right")) {
//                l.theseus.moveRight(1);
//                l.minotaur.moveRandomSmart(mSpeed, l.theseus);
//            } else if (move.equals("up")) {
//                l.theseus.moveUp(1);
//                l.minotaur.moveRandomSmart(mSpeed, l.theseus);
//            } else if (move.equals("down")) {
//                l.theseus.moveDown(1);
//                l.minotaur.moveRandomSmart(mSpeed, l.theseus);
//            } else {
//                System.out.println("Move not recognized, try again");
//            }
//            
//            // Establish win/lose conditions
//            
//            if (l.theseus.getX() == l.minotaur.getX() &&
//                l.theseus.getY() == l.minotaur.getY()) {
//                
//                printGrid(x, y, l.theseus.getX(), l.theseus.getY(), l.minotaur.getX(), l.minotaur.getY());
//                System.out.println(" ");
//                System.out.println("Oh no! The Minotaur caught you!");
//                System.out.println("GAME OVER");
//                gameOver = true;
//                
//            } else if (l.theseus.getX() == (x+1)/2 &&
//                       l.theseus.getY() == y) {
//                
//                printGrid(x, y, l.theseus.getX(), l.theseus.getY(), l.minotaur.getX(), l.minotaur.getY());
//                System.out.println(" ");
//                System.out.println("You escaped the Labyrinth!");
//                System.out.println("CONGRATULATIONS");
//                gameOver = true;
//            }
//        }                                
//    }
//    
//    // Print the grid, marking the exit with X
//    public void printGrid(int x, int y, int tX, int tY, int mX, int mY) {
//        
//        String exitLine = "";
//        for (int i = 1; i < x; i++) {
//            if (i == (x+1)/2) {
//                exitLine += " X ";
//            } else {
//                exitLine += "   ";
//            }
//        }
//        
//        System.out.println(exitLine);
//        for (int i = y; i >= 1; i--) {
//            String line = "";
//            for (int j = 1; j <= x; j++) {
//                if (mX == j && 
//                    mY == i) {
//                    line += " M ";
//                } else if (tX == j && 
//                           tY == i) {
//                    line += " T ";
//                } else {
//                    line += " _ ";
//                }
//            }
//            System.out.println(line);
//        }
//    }
                    