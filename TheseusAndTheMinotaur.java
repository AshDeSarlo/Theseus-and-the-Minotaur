// Ash DeSarlo
// Theseus and the Minotaur
// COmputer Architecture Conference Project

import java.util.*;
import java.awt.event.*;

public class TheseusAndTheMinotaur {
    
    public static void main(String[] args) {
        TheseusAndTheMinotaur d = new TheseusAndTheMinotaur();
        d.TheseusAndTheMinotaur(5,10);
    }
        
    public void TheseusAndTheMinotaur(int x, int y) {
        
        player theseus = new player("Theseus", (x+1)/2, 1, 1, x, y, 1, 1);
        
        ArrayList<enemy> npc_list = new ArrayList<enemy>();
        enemy minotaur = new enemy("Minotaur", (x+1)/2, y, 2, x, y, 1, 1);
        
        enemy skeleton_1 = new enemy("Skeleton", x, 1, 1, x, y, 1, 1);
        enemy skeleton_2 = new enemy("Skeleton", 1, 1, 1, x, y, 1, 1);
        
        enemy bat_1 = new enemy("Bat", x, y, 2, x, y, 1, 1);
        bat_1.setSmart(false);
        enemy bat_2 = new enemy("Bat", 1, y, 2, x, y, 1, 1);
        bat_2.setSmart(false);
        
        npc_list.add(minotaur);
        npc_list.add(skeleton_1);
        npc_list.add(skeleton_2);
        npc_list.add(bat_1);
        npc_list.add(bat_2);
        
        Labyrinth l = new Labyrinth(x, y, theseus, npc_list);
        }                                
    }
    