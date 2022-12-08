import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class LabyrinthDataReader {
        
    public int num_rows;
    public int num_columns;
    
    public player player;
    
    public String player_name;
    public int player_speed;
    public boolean start_back;
    public boolean start_center;
    public boolean start_random;
    
    public int player_x;
    public int player_y;

    public int num_enemies;
    public int num_items;
    
    public ArrayList<enemy> enemy_list;
    public ArrayList<Item> item_list;
    
    public LabyrinthDataReader(String filename) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));
        
        in.nextLine();
        in.nextLine();
        
        // Get board dimensions
        
        this.num_rows = Integer.parseInt(in.next());
        in.nextLine();
        this.num_columns = Integer.parseInt(in.next());
        in.nextLine();
        
        in.nextLine();
        in.nextLine();
        in.nextLine();
        
        // Get player name and speed
        
        this.player_name = in.next();
        in.nextLine();
        this.player_speed = Integer.parseInt(in.next());
        in.nextLine();
        
        // Get starting location variable
        
        int current = Integer.parseInt(in.next());
        if (current == 1) {
            this.start_back = true;
        }
        in.nextLine();
        
        current = Integer.parseInt(in.next());
        if (current == 1) {
            this.start_center = true;
        }
        in.nextLine();
        
        current = Integer.parseInt(in.next());
        if (current == 1) {
            this.start_random = true;
        }
        in.nextLine();
        
        // Set starting location
        
        if (this.start_back) {
            this.player_x = this.num_columns / 2;
            this.player_y = 1;
        } else if (this.start_center) {
            this.player_x = this.num_columns / 2;
            this.player_y = this.num_rows / 2;
        } else {
            this.player_x = randRange(1, this.num_columns);
            this.player_y = randRange(1, this.num_rows - 1);
        }
        
        this.player = new player(this.player_name, this.player_x, this.player_y, this.player_speed,
                                 this.num_columns, this.num_rows, 1, 1);
        
        in.nextLine();
        in.nextLine();
        in.nextLine();
        
        // Get number of enemies
            
        this.num_enemies = Integer.parseInt(in.next());
        in.nextLine();
        
        in.nextLine();
        
        // Loop to make list of enemies
        
        this.enemy_list = new ArrayList<enemy>();
        
        for (int i = 0; i < this.num_enemies; i++) {
            String current_name = in.next();
            in.nextLine();
            
            int current_speed = Integer.parseInt(in.next());
            in.nextLine();
            
            int current_smart_val = Integer.parseInt(in.next());
            in.nextLine();
            
            boolean current_is_smart;
            if (current_smart_val == 1) {
                current_is_smart = true;
            } else {
                current_is_smart = false;
            }
            
            int current_random_val = Integer.parseInt(in.next());
            in.nextLine();
            
            int current_x;
            int current_y; 
            
            if (current_random_val == 1) {
                current_x = randRange(1, this.num_columns);
                current_y = randRange(2, this.num_rows);
                in.nextLine();
                in.nextLine();
            } else {
                current_x = Integer.parseInt(in.next());
                in.nextLine();
                current_y = Integer.parseInt(in.next());
                in.nextLine();
            }
            
            enemy current_enemy = new enemy(current_name, current_x, current_y, current_speed,
                                            this.num_columns, this.num_rows, 1, 1);
            current_enemy.setSmart(current_is_smart);
            this.enemy_list.add(current_enemy);
        }
        
        in.nextLine();
        in.nextLine();
        in.nextLine();
        
        // Get number of items
            
        this.num_items = Integer.parseInt(in.next());
        in.nextLine();
        
        in.nextLine();
        
        // Loop to make item list
        
         this.item_list = new ArrayList<Item>();
        
        for (int i = 0; i < this.num_items; i++) {
            String current_name = in.next();
            in.nextLine();
            
            int current_random_val = Integer.parseInt(in.next());
            in.nextLine();
            
            int current_x;
            int current_y;
            
            if (current_random_val == 1) {
                current_x = randRange(1, this.num_columns);
                current_y = randRange(2, this.num_rows);
                in.nextLine();
                in.nextLine();
            } else {
                current_x = Integer.parseInt(in.next());
                in.nextLine();
                current_y = Integer.parseInt(in.next());
                in.nextLine();
            }
            
            Item current_item = new Item(current_name, current_x, current_y);
            this.item_list.add(current_item);
        }   
    }
    
    public player getPlayer() {
        return this.player;
    }
    
    public ArrayList<enemy> getEnemyList() {
        return this.enemy_list;
    }
    
    public int getRows() {
        return this.num_rows;
    }
    
    public int getColumns() {
        return this.num_columns;
    }
    
    public ArrayList<Item> getItemList() {
        return this.item_list;
    }
        
    public int randRange(int start, int end) {
        Random generator = new Random();
        int x = generator.nextInt(end - start) + start;
        return x;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        LabyrinthDataReader d = new LabyrinthDataReader("newData.txt");
    }
   
}