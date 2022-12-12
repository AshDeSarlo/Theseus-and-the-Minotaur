// Ash DeSarlo
// Theseus and the Minotaur
// COmputer Architecture Conference Project

import java.util.*;
import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class TheseusAndTheMinotaur {
    
    public static void main(String[] args) throws FileNotFoundException {
        TheseusAndTheMinotaur d = new TheseusAndTheMinotaur();
        d.TheseusAndTheMinotaur();
    }
        
    public void TheseusAndTheMinotaur() throws FileNotFoundException {
        
        LabyrinthDataReader d;
        
        // Ask user for custom files
        
        int choice_1 = JOptionPane.showConfirmDialog(null, "Do you want to load a custom file?", "Custom file?",
                                                JOptionPane.YES_NO_OPTION);
        if(choice_1 == 0) {
            // New file or existing one
            int choice_2 = JOptionPane.showConfirmDialog(null, "Create new file?", "New file?",
                                                JOptionPane.YES_NO_OPTION);
            String filename;
            if (choice_2 == 0) {
                
                // Generate new file
                createNewDataFile f = new createNewDataFile(); 
                filename = f.getFilename();
                
                // Insert pause for editing new file
                JOptionPane.showMessageDialog(null, "New file created: " + filename, "New File Created", 
                                              JOptionPane.PLAIN_MESSAGE);
            } else {
                filename = JOptionPane.showInputDialog("Please enter name of custom file:"); 
            }
            d = new LabyrinthDataReader(filename);
                
        } else {
            // Base game
            d = new LabyrinthDataReader("main.txt");
        }
        
        Labyrinth l = new Labyrinth(d.getColumns(), d.getRows(), d.getPlayer(), d.getEnemyList());
        
        }                                
    }
    