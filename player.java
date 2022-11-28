// Ash DeSarlo

import java.util.*;

public class player {
    
    public String name;
    public int x;
    public int y;
    public int maxX;
    public int maxY;
    public int minX;
    public int minY;
    public int speed;
    public ArrayList<Item> inventory;
    
    
    public player(String name, int x, int y, int speed, int maxX, int maxY, int minX, int minY) {
        this.name = name;
        this.x = x;
        this.y = y; 
        this.speed = speed;
        this.setMaxMin(maxX, maxY, minX, minY);
        this.inventory = new ArrayList<Item>();
    }
    
    public player(String name, int x, int y, int speed) {
        this.name = name;
        this.x = x;
        this.y = y;  
        this.speed = speed;
        this.setMaxMin(100, 100, -100, -100);
        this.inventory = new ArrayList<Item>();
    }
    
    public player(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;  
        this.speed = 1;
        this.setMaxMin(100, 100, -100, -100);
        this.inventory = new ArrayList<Item>();
    }
    
    public player(String name) {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.speed = 1;
        this.setMaxMin(100, 100, -100, -100);
        this.inventory = new ArrayList<Item>();
    }
    
    public String toString() {
        return this.name;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setMaxMin(int maxX, int maxY, int minX, int minY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.minX = minX;
        this.minY = minY;
    }
        
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    // Movement Commands
    
    // takes a number of steps to take, then
    // increments the player's coordinates
    // but not beyond max and min values
    
    public void moveLeft(int numMoves) {
        for (int i = 0; i < numMoves; i++) {
            if (this.x-1 >= this.minX) {
                this.x--;
            }
        }
    }
    
    public void moveRight(int numMoves) {
        for (int i = 0; i < numMoves; i++) {
            if (this.x+1 <= this.maxX) {
                this.x++;
            }
        }
    }
    
    public void moveUp(int numMoves) {
        for (int i = 0; i < numMoves; i++) {
            if (this.y+1 <= this.maxY) {
                this.y++;
            }
        }
    }
    
    public void moveDown(int numMoves) {
        for (int i = 0; i < numMoves; i++) {
            if (this.y-1 >= this.minY) {
                this.y--;
            }
        }
    }
    
    // Movement commands Generalized
    
    // Ifno args are presented, uses speed
    
    public void moveLeft() {
        for (int i = 0; i < this.speed; i++) {
            if (this.x-1 >= this.minX) {
                this.x--;
            }
        }
    }
    
    public void moveRight() {
        for (int i = 0; i < this.speed; i++) {
            if (this.x+1 <= this.maxX) {
                this.x++;
            }
        }
    }
    
    public void moveUp() {
        for (int i = 0; i < this.speed; i++) {
            if (this.y+1 <= this.maxY) {
                this.y++;
            }
        }
    }
    
    public void moveDown() {
        for (int i = 0; i < this.speed; i++) {
            if (this.y-1 >= this.minY) {
                this.y--;
            }
        }
    }
    
    // Inventory support
    
    public void addItem(Item item) {
        this.inventory.add(item);
    }
    
    public Boolean hasItem(Item item) {
        if (this.inventory.contains(item)) {
            return true;
        } else {
            return false;
        }
    }
    
    public void printInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).toString());
        } 
    }
    
}