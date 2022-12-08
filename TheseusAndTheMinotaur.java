// Ash DeSarlo
// Theseus and the Minotaur
// COmputer Architecture Conference Project

import java.util.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

public class TheseusAndTheMinotaur {
    
    public static void main(String[] args) throws FileNotFoundException {
        TheseusAndTheMinotaur d = new TheseusAndTheMinotaur();
        d.TheseusAndTheMinotaur();
    }
        
    public void TheseusAndTheMinotaur() throws FileNotFoundException {
        
        LabyrinthDataReader d = new LabyrinthDataReader("main.txt");
        
        Labyrinth l = new Labyrinth(d.getColumns(), d.getRows(), d.getPlayer(), d.getEnemyList());
        }                                
    }
    