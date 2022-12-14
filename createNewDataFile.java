// Ash DeSarlo

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class createNewDataFile {
    
    String filename;
    
    public createNewDataFile() throws FileNotFoundException {
        
        // Get name of new file
        this.filename = JOptionPane.showInputDialog("Please enter name of new file (.txt):");      
        
        
        if (filename.equals("")) {
            filename = "newData.txt";
        } else {
            filename = filename + ".txt";
        }
        
        
        // Write basic data
        File file = new File(filename);
        
        PrintWriter writer = new PrintWriter(file);
        
        writer.println(" - - - Board Data - - - \n");
        
        writer.println("10 num_rows");
        writer.println("10 num_columns");
        
        writer.println("\n - - - Player Data - - -\n");
        
        writer.println("Theseus player_name");
        writer.println("1 player_speed");
        writer.println("1 start_back");
        writer.println("0 start_center");
        writer.println("0 start_random");
        
        writer.println("\n - - - Enemy Data - - -\n");
        
        writer.println("1 num_enemies");
        
        writer.println("");
        
        writer.println("Minotaur enemy_name");
        writer.println("2 enemy_speed");
        writer.println("1 is_smart");
        writer.println("0 random_start");
        writer.println("5 start_x");
        writer.println("10 start_y");
        
        writer.println("\n - - - Item Data - - -\n");
        
        writer.println("1 num_items");
        writer.println("");
        
        writer.println("Sword item_name");
        writer.println("1 random_start");
        writer.println("0 start_x");
        writer.println("0 start_y");
        
        writer.close();
        
        System.out.println("Done");
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        createNewDataFile d = new createNewDataFile();
    }
    
    public String getFilename() {
        return this.filename;
    }
    
}
