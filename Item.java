// Ash DeSarlo

public class Item {
    
    public String name;
    public int x;
    public int y;
    
    public Item(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return this.name;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
}