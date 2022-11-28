// Ash DeSarlo

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Labyrinth extends JFrame implements KeyListener {
    
    public int rows;
    public int columns;
    
    public player pc;
    public ArrayList<enemy> npc_list;
    public ArrayList<Item> item_list;
    public Item sword;
    
    public JPanel playPanel;
    public JPanel mainPanel;
    public JPanel inventoryPanel;
    public JPanel enemyPanel;
    public JLabel nameTag;
    public JLabel feedbackDisplay;
    
    public boolean gameOver;
    
    public Labyrinth (int columns, int rows, player playerPC, ArrayList<enemy> enemyNPC_list, ArrayList<Item> item_list) {
        
        // Instance Variables
        
        this.gameOver = false;
        this.rows = rows;
        this.columns = columns;
        this.pc = playerPC;
        this.npc_list = enemyNPC_list; 
        this.item_list = item_list;
        
        this.setBackground(Color.WHITE);
        
        this.addKeyListener(this);
        this.setFocusable(true);
        
        this.updatePanel();  
    }
    
    // Second initialization, with the one base item (The Theseus Sword)
    
    public Labyrinth (int columns, int rows, player playerPC, ArrayList<enemy> enemyNPC_list) {
        
        // Instance Variables
        
        this.gameOver = false;
        this.rows = rows;
        this.columns = columns;
        this.pc = playerPC;
        this.npc_list = enemyNPC_list; 
        
        this.item_list = new ArrayList<Item>();
        this.sword = new Item("Theseus Sword", randRange(1, this.columns), randRange(1, this.rows - 1));
        this.item_list.add(sword);
        
        this.setBackground(Color.WHITE);
        
        this.addKeyListener(this);
        this.setFocusable(true);
        
        this.updatePanel();  
    }
    
    // Key Listener
    
    public void keyPressed(KeyEvent e) {
        int action = e.getKeyCode();
        
        if (this.gameOver == false) {
            if (action == KeyEvent.VK_RIGHT ||
                action == KeyEvent.VK_D) {
                if (this.pc.getX() < this.columns) {
                    this.pc.moveRight(1);
                    this.move_NPCs();
                }
            } 
            if (action == KeyEvent.VK_LEFT ||
                action == KeyEvent.VK_A) {
                if (this.pc.getX() > 1) {
                    this.pc.moveLeft(1);
                    this.move_NPCs();
                }
            } 
            if (action == KeyEvent.VK_UP ||
                action == KeyEvent.VK_W) {
                if (this.pc.getY() < this.rows) {
                    this.pc.moveUp(1);
                    this.move_NPCs();
                }
            } 
            if (action == KeyEvent.VK_DOWN ||
                action == KeyEvent.VK_S) {
                if (this.pc.getY() > 1) {
                    this.pc.moveDown(1);
                    this.move_NPCs();
                }
            } 
            this.updatePanel();
        }
    }
    public void keyReleased(KeyEvent e) {
        this.updatePanel();
    }
    public void keyTyped(KeyEvent e) {
    }
    
   
    // Function to update frame for simple animation
    
    public void updatePanel() {
        
        // Create the window
        
        this.mainPanel = new JPanel();
        this.mainPanel.setBackground(Color.WHITE);
        this.mainPanel.setLayout(new BorderLayout());
        
        this.playPanel = new JPanel();
        this.playPanel.setBackground(Color.WHITE);
        this.playPanel.setLayout(new GridLayout(this.rows, this.columns));
        
        this.nameTag = new JLabel("THESEUS VS. THE MINOTAUR", SwingConstants.CENTER);
        this.nameTag.setBackground(Color.WHITE);
        Font titleFont = new Font("Felix Titling", Font.BOLD, 50);
        this.nameTag.setFont(titleFont);
        
        // Create Inventory Panel
        
        this.inventoryPanel = new JPanel();
        this.inventoryPanel.setBackground(Color.WHITE);
        this.inventoryPanel.setLayout(new BorderLayout());
        
        Font sidebarTitleFont = new Font("Felix Titling", Font.BOLD, 25);
        Font sidebarFont = new Font("Felix Titling", Font.BOLD, 20);
        
        JLabel inventoryLabel = new JLabel("  Inventory  ", SwingConstants.CENTER);
        inventoryLabel.setFont(sidebarTitleFont);
        this.inventoryPanel.add(inventoryLabel, BorderLayout.NORTH);
        
        JPanel inventoryListPanel = new JPanel();
        inventoryListPanel.setLayout(new GridLayout(this.pc.inventory.size(), 1));
        inventoryListPanel.setBackground(Color.WHITE);
        
        for (int i = 0; i < this.pc.inventory.size(); i++) {
            Item currentItem = this.pc.inventory.get(i);
            JLabel currentLabel = new JLabel(currentItem.toString(), SwingConstants.CENTER);
            currentLabel.setFont(sidebarFont);
            inventoryListPanel.add(currentLabel);
        }
        
        this.inventoryPanel.add(inventoryListPanel);
        
        // Create Enemy List Panel
        
        this.enemyPanel = new JPanel();
        this.enemyPanel.setBackground(Color.WHITE);
        this.enemyPanel.setLayout(new BorderLayout());
        
        JLabel enemyLabel = new JLabel("  Enemies  ", SwingConstants.CENTER);
        enemyLabel.setFont(sidebarTitleFont);
        this.enemyPanel.add(enemyLabel, BorderLayout.NORTH);
        
        JPanel enemyListPanel = new JPanel();
        enemyListPanel.setLayout(new GridLayout(this.npc_list.size(), 1));
        enemyListPanel.setBackground(Color.WHITE);
        
        for (int i = 0; i < this.npc_list.size(); i++) {
            enemy currentEnemy = this.npc_list.get(i);
            JLabel currentLabel = new JLabel(currentEnemy.toString(), SwingConstants.CENTER);
            currentLabel.setFont(sidebarFont);
            enemyListPanel.add(currentLabel);
        }
        
        this.enemyPanel.add(enemyListPanel);
        
        // Create game section block by block
        
        for (int y = this.rows; y > 0; y--) {
            for (int x = 1; x <= this.columns; x++) {
                
                String enemyMarker = "";
                String itemMarker = "";
                
                boolean hasTheseus = false;
                boolean hasEnemy = false;
                boolean isExit = false;
                boolean hasItem = false;
                
                // Place Theseus
                if (this.pc.getX() == x &&
                    this.pc.getY() == y) {
                    hasTheseus = true;
                } 
                
                // Place enemies
                for (int i = 0; i < npc_list.size(); i++) {
                    enemy current = npc_list.get(i);
                    if (current.getX() == x &&
                        current.getY() == y) {
                        hasEnemy = true;
                        enemyMarker = Character.toString(current.toString().charAt(0));
                    }
                }
                
                // Place Exit
                if (x == (this.columns+1)/2 &&
                    y == this.rows) {
                    isExit = true;
                }
                
                // Place Items
                for (int i = 0; i < item_list.size(); i++) {
                    Item current = item_list.get(i);
                    if (current.getX() == x &&
                        current.getY() == y) {
                        hasItem = true;
                        itemMarker = Character.toString(current.toString().charAt(0));
                    }
                }
                    
                // Create frame block
                LPanel current = new LPanel(x, y, this.columns, this.rows, 
                                            hasTheseus, hasEnemy, isExit, hasItem,
                                            enemyMarker, itemMarker);
                this.playPanel.add(current);
            }
        }
        
        String s = " ";
        
        // Check for collision with enemies
        
        for (int i = 0; i < this.npc_list.size(); i++) {
            enemy current = this.npc_list.get(i);
           
            // If Theseus has the sword, he kills the enemy! If not...
            if (this.pc.getX() == current.getX() &&
                this.pc.getY() == current.getY()) {
                
                if (this.pc.hasItem(sword)) {
                    s = "You killed the " + current.toString() + "!";
                    this.npc_list.remove(i);
                    
                    // Win Condition: Defeat all enemies
                    if (this.npc_list.size() == 0) {
                        s = "Conratulations! All enemies have been defeated!";
                        this.gameOver = true;
                    }
                    
             // The enemy kills Theses
                } else {
                    s = "Oh no! The " + current.toString() + " caught you!";
                    this.gameOver = true;
                }
            }
        }
        
        // Pickup  Items
        for (int i = 0; i < this.item_list.size(); i++) {
            Item current = this.item_list.get(i);
            if (this.pc.getX() == current.getX() &&
                this.pc.getY() == current.getY()) {
                
                s = "You picked up the " + current.toString() + "!";
                this.pc.addItem(current);
                this.item_list.remove(i);
            }
        }
        
        // Win condition: Escape
        if (this.pc.getX() == (this.columns+1)/2 &&
            this.pc.getY() == this.rows) {
            s = "Congratulations! You escaped!";
            this.gameOver = true;
        }
        
        // Add all panels
        this.feedbackDisplay = new JLabel(s, SwingConstants.CENTER);
        this.feedbackDisplay.setBackground(Color.WHITE);
        Font feedbackFont = new Font("Felix Titling", Font.BOLD, 50);
        this.feedbackDisplay.setFont(feedbackFont);
        
        this.mainPanel.add(this.playPanel, BorderLayout.CENTER);
        this.mainPanel.add(this.nameTag, BorderLayout.NORTH);
        this.mainPanel.add(this.feedbackDisplay, BorderLayout.SOUTH);
        this.mainPanel.add(this.inventoryPanel, BorderLayout.EAST);
        this.mainPanel.add(this.enemyPanel, BorderLayout.WEST);
        
        this.setVisible(true);
        this.setSize(1500, 1000);
        this.add(this.mainPanel);
    }
    
    // Move all enemies at once
    public void move_NPCs() {
        for (int i = 0; i < npc_list.size(); i++) {
            enemy current = npc_list.get(i);
            current.move(this.pc);
        }
    }
    
    // Special class of JPanel to create blocks for frame
    public class LPanel extends JPanel{
        
        // Instance
        public int x;
        public int y;
        public int maxX;
        public int maxY;
        public boolean hasTheseus;
        public boolean hasEnemy;
        public boolean isExit;
        public boolean hasItem;
        public String enemyMarker;
        public String itemMarker;
        
        public LPanel(int x, int y, int maxX, int maxY, 
                      boolean hasTheseus, boolean hasEnemy, boolean isExit, boolean hasItem, 
                      String enemyMarker, String itemMarker) {
            this.x = x;
            this.y = y;
            this.maxX = maxX;
            this.maxY = maxY;
            this.hasTheseus = hasTheseus;
            this.hasEnemy = hasEnemy;
            this.isExit = isExit;
            this.hasItem = hasItem;
            this.enemyMarker = enemyMarker;
            this.itemMarker = itemMarker;
            
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
            
            // Mark special squares for Theseus, enemies, items, and the exit
            
            JLabel body;
            
            String bodyText = "";
            body = new JLabel(bodyText, SwingConstants.CENTER);
            Font font = new Font("Poor Richard", Font.BOLD, 50);
            if (this.hasEnemy) { 
                bodyText = this.enemyMarker;
                body.setForeground(Color.RED);
            } else {
                if (this.hasTheseus) { 
                    bodyText = "T";
                    body.setForeground(Color.BLUE);
                } else if (this.hasItem) {
                    bodyText = this.itemMarker;
                    body.setForeground(Color.GREEN);
                } else if (this.isExit) {
                    bodyText = "Exit";
                } else {
                    bodyText = "";
                    
                }
            }
            body.setText(bodyText);
            body.setFont(font);
            this.add(body, BorderLayout.CENTER);
                
        }
        
    }
    
    public int randRange(int start, int end) {
        Random generator = new Random();
        int x = generator.nextInt(end - start) + start;
        return x;
    }

    
    //---------------------------------------------------------------------------

    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        player theseus = new player("Theseus", (x+1)/2, 1, 1, x, y, 1, 1);
        ArrayList<enemy> npc_list = new ArrayList<enemy>();
        enemy minotaur = new enemy("Minotaur", (x+1)/2, y, 2, x, y, 1, 1);
        npc_list.add(minotaur);
        Labyrinth l = new Labyrinth(x, y, theseus, npc_list);
    }
    
}