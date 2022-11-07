// Ash DeSarlo

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Labyrinth extends JFrame {
    
    public int rows;
    public int columns;
    public player theseus;
    public enemy minotaur;
    public JPanel mainPanel;
    
    public Labyrinth (int columns, int rows) {
        
        // Instance Variables
        this.rows = rows;
        this.columns = columns;
        this.theseus = new player("Theseus", (this.columns+1)/2, 1, this.columns, this.rows, 1, 1);
        this.minotaur = new enemy("Minotaur", (this.columns+1)/2, this.rows, this.columns, this.rows, 1, 1);
        
        this.setBackground(Color.WHITE);
        this.updatePanel();
    }
    
    // Function to update frame for simple animation
    
    public void updatePanel() {
        this.mainPanel = new JPanel();
        this.mainPanel.setBackground(Color.WHITE);
        this.mainPanel.setLayout(new GridLayout(this.rows, this.columns));
        
        // Create frame block by block
        for (int y = this.rows; y > 0; y--) {
            for (int x = 1; x <= this.columns; x++) {
                
                //String s = "X = " + x + " , " + "Y = " + y;
                //System.out.println(s);
                boolean hasTheseus = false;
                boolean hasMinotaur = false;
                boolean isExit = false;
                
                //Check for locations of Theseus, Minotaur, and Exit
                if (this.theseus.getX() == x &&
                    this.theseus.getY() == y) {
                    hasTheseus = true;
                    //System.out.println("Theseus is here");
                } 
                if (this.minotaur.getX() == x &&
                    this.minotaur.getY() == y) {
                    //System.out.println("Minotaur is here");
                    hasMinotaur = true;
                }
                if (x == (this.columns+1)/2 &&
                    y == this.rows) {
                    isExit = true;
                    //System.out.println("Exit is here");
                }
                    
                // Create frame block
                LPanel current = new LPanel(x, y, this.columns, this.rows, hasTheseus, hasMinotaur, isExit);
                this.mainPanel.add(current);
            }
        }
        
        this.setVisible(true);
        this.setSize(1200, 800);
        this.add(this.mainPanel);
       
    }
    
    // Special class of JPanel to create blocks for frame
    public class LPanel extends JPanel{
        
        // Instance (theoretically redudant at this stage)
        public int x;
        public int y;
        public int maxX;
        public int maxY;
        public boolean hasTheseus;
        public boolean hasMinotaur;
        public boolean isExit;
        
        public LPanel(int x, int y, int maxX, int maxY, boolean hasTheseus, boolean hasMinotaur, boolean isExit) {
            this.x = x;
            this.y = y;
            this.maxX = maxX;
            this.maxY = maxY;
            this.hasTheseus = hasTheseus;
            this.hasMinotaur = hasMinotaur;
            this.isExit = isExit;
            
            this.setLayout(new BorderLayout());
            this.setBackground(Color.WHITE);
            
            if (this.isExit) {
                
                // Mark Exit with Red
                
                JPanel leftWall = new JPanel();
                JPanel bottomWall = new JPanel();
                JPanel rightWall = new JPanel();
                JPanel topWall = new JPanel();

                leftWall.setBackground(Color.RED);
                bottomWall.setBackground(Color.RED);
                rightWall.setBackground(Color.RED);
                topWall.setBackground(Color.RED);
                
                this.add(leftWall, BorderLayout.WEST);
                this.add(rightWall, BorderLayout.EAST);
                //this.add(topWall, BorderLayout.NORTH);
                this.add(bottomWall, BorderLayout.SOUTH);
            
            } else {
                
                // All other squares will have grey outlines 
                // If they contain a wall, that wall will be black
                
                JPanel leftWall = new JPanel();
                JPanel bottomWall = new JPanel();
                JPanel rightWall = new JPanel();
                JPanel topWall = new JPanel();
                
                if (this.x == 1) {
                    leftWall.setBackground(Color.BLACK);
                } else {
                    leftWall.setBackground(Color.LIGHT_GRAY);
                }

                if (this.y == 1) {
                    bottomWall.setBackground(Color.BLACK);
                } else {
                    bottomWall.setBackground(Color.LIGHT_GRAY);
                }
                
                if (this.x == this.maxX) {
                    rightWall.setBackground(Color.BLACK);
                } else {
                    rightWall.setBackground(Color.LIGHT_GRAY);
                }
                
                if (this.y == this.maxY) {
                    topWall.setBackground(Color.BLACK);
                } else {
                    topWall.setBackground(Color.LIGHT_GRAY);
                }
                
                this.add(leftWall, BorderLayout.WEST);
                this.add(rightWall, BorderLayout.EAST);
                this.add(topWall, BorderLayout.NORTH);
                this.add(bottomWall, BorderLayout.SOUTH);
                
            } 
                
            this.setVisible(true);
            
            // Mark special squares for Theseus, Minotaur, and Exit
            
            JLabel body;
            String bodyText;
            Font font = new Font("Poor Richard", Font.BOLD, 50);
            if (this.hasMinotaur) { 
                bodyText = "M";
            } else {
                if (this.hasTheseus) { 
                    bodyText = "T";
                } else if (this.isExit) {
                    bodyText = "Exit";
                } else {
                    bodyText = "";
                    //Font font = new Font("Poor Richard", Font.BOLD, 50);
                    //bodyText = "X = " + this.x + " , " + "Y = " + this.y;
                    
                }
            }
            body = new JLabel(bodyText, SwingConstants.CENTER);
            body.setFont(font);
            this.add(body, BorderLayout.CENTER);
                
        }
        
    }

    
    //---------------------------------------------------------------------------

    public static void main(String[] args) {
        Labyrinth l = new Labyrinth(5,10);
    }
    
}