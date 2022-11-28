// Ash DeSarlo

import java.util.*;

public class enemy extends player {
    public boolean isSmart;
    
    public enemy(String name, int x, int y, int speed, int maxX, int maxY, int minX, int minY) {
        super(name, x, y, speed, maxX, maxY, minX, minY);
        this.isSmart = true;
    }
    
    public enemy(String name, int x, int y, int speed) {
        super(name, x, y, speed);
        this.isSmart = true;
    }
    
    public enemy(String name, int x, int y) {
        super(name, x, y);
        this.isSmart = true;
    }
    
    public enemy(String name) {
        super(name);
        this.isSmart = true;
    }
    
    public void setSmart(boolean smart) {
        this.isSmart = smart;
    }
    
    public void move(int numMoves, player other) {
        if (this.isSmart) {
            this.moveRandomSmart(numMoves, other);
        } else {
            this.moveRandom(numMoves);
        }
    }
    
    public void move(player other) {
        if (this.isSmart) {
            this.moveRandomSmart(this.speed, other);
        } else {
            this.moveRandom(this.speed);
        }
    }
    
    // basic, randomly generated movement
    public void moveRandom(int numMoves) {
        
        // Generate a list of possible moves
        ArrayList<String> directionsList;
        for (int i = 0; i < numMoves; i++) {
            directionsList = new ArrayList<String>();
            if (this.x < this.maxX) {
                directionsList.add("Right");
            }
            if (this.x > this.minX) {
                directionsList.add("Left");
            }
            if (this.y < this.maxY) {
                directionsList.add("Up");
            }
            if (this.y > this.minY) {
                directionsList.add("Down");
            }
            
            // randomly select one move from list
            String direction = directionsList.get(randRange(0, directionsList.size()));
            
            // execute move
            if (direction.equals("Up")) {
                this.moveUp(1);
            } else if (direction.equals("Right")) {
                this.moveRight(1);
            } else if (direction.equals("Down")) {
                this.moveDown(1);
            } else {
                this.moveLeft(1);
            }
        }
    }
    
    // slightly more intelligent movement generation with
    // limited tracking of player's location
    public void moveRandomSmart(int numMoves, player other) {
        int otherPositionX = other.getX();
        int otherPositionY = other.getY();
        ArrayList<String> directionsList;
        
        // When generating list of potential moves,
        // determines which direction the player is in,
        // and adds extra weight to those moves
        
        for (int i = 0; i < numMoves; i++) {
            directionsList = new ArrayList<String>();
            
            if (this.x < this.maxX) {
                directionsList.add("Right");
                if (this.x < otherPositionX) {
                    directionsList.add("Right");
                    directionsList.add("Right");
                }
            }
            
            if (this.x > this.minX) {
                directionsList.add("Left");
                if (this.x > otherPositionX) {
                    directionsList.add("Left");
                    directionsList.add("Left");
                }
            }
            
            if (this.y < this.maxY) {
                directionsList.add("Up");
                if (this.y < otherPositionY) {
                    directionsList.add("Up");
                    directionsList.add("Up");
                }
            }
            
            if (this.y > this.minY) {
                directionsList.add("Down");
                if (this.y > otherPositionY) {
                    directionsList.add("Down");
                    directionsList.add("Down");
                }
            }
            
            String direction = directionsList.get(randRange(0, directionsList.size()));
            
            // to see weighted list of move options, uncomment line below
            
            //System.out.println(directionsList);
            
            if (direction.equals("Up")) {
                this.moveUp(1);
            } else if (direction.equals("Right")) {
                this.moveRight(1);
            } else if (direction.equals("Down")) {
                this.moveDown(1);
            } else {
                this.moveLeft(1);
            }
        }
    }
    
    public void moveRandomSmart(player other) {
        int otherPositionX = other.getX();
        int otherPositionY = other.getY();
        ArrayList<String> directionsList;
        
        // When generating list of potential moves,
        // determines which direction the player is in,
        // and adds extra weight to those moves
        
        for (int i = 0; i < this.speed; i++) {
            directionsList = new ArrayList<String>();
            
            if (this.x < this.maxX) {
                directionsList.add("Right");
                if (this.x < otherPositionX) {
                    directionsList.add("Right");
                    directionsList.add("Right");
                }
            }
            
            if (this.x > this.minX) {
                directionsList.add("Left");
                if (this.x > otherPositionX) {
                    directionsList.add("Left");
                    directionsList.add("Left");
                }
            }
            
            if (this.y < this.maxY) {
                directionsList.add("Up");
                if (this.y < otherPositionY) {
                    directionsList.add("Up");
                    directionsList.add("Up");
                }
            }
            
            if (this.y > this.minY) {
                directionsList.add("Down");
                if (this.y > otherPositionY) {
                    directionsList.add("Down");
                    directionsList.add("Down");
                }
            }
            
            String direction = directionsList.get(randRange(0, directionsList.size()));
            
            // to see weighted list of move options, uncomment line below
            
            //System.out.println(directionsList);
            
            if (direction.equals("Up")) {
                this.moveUp(1);
            } else if (direction.equals("Right")) {
                this.moveRight(1);
            } else if (direction.equals("Down")) {
                this.moveDown(1);
            } else {
                this.moveLeft(1);
            }
        }
    }
    
    // random helper function
    public int randRange(int start, int end) {
        Random generator = new Random();
        int x = generator.nextInt(end - start) + start;
        return x;
    }
}