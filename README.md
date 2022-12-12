# Theseus-and-the-Minotaur

This project is a simple, turn-based game featuring Theseus trying to escape the Minotaur. 
The game itself is fairy basic, with simple keyboard-based controls (wasd or arrow keys) for 
navigating the room while the Minotaur, or a number of other enemies, moves about the room. 
The goal of the game is either to make it to the exit on the other side, or find the sword 
somewhere in the room and use it to defeat the Minotaur before it catches you.

There are a number of variable factors in the game that can easily be tweaked, such as the 
size of the board and the name of the player. The real variance comes with the enemies, which 
can be customized with increased speed, multiple copies, randomized placement, and even with 
limited ability to track down the player as opposed to "dumb" (or random) movement.

All of these variables come into play with the implementation of custom files. While there is 
a base game with all the features included, the user is prompted on whether they would like to 
create or import a text file that contains the relavent information necessary for initializing 
the game. Here, a user with no knowledge of Java coding can simply open the text file, change
the variables used to generate the board, then import it in when starting up the game to easily
create custom levels for the game without any prior coding experience. Some copy and pasting is 
required to use these files to their full advantage, but no true coding experience is necessary.

If given more time to work on this, I would implement the follwoing features:

  1. Collision detection for LPanels, allowing walls to be place inside the board and increase
     variation  of play
     
  2. Hazards on the board, such as spike pits, that would give a game over screen if encountered
  
  3. Preset levels that the user could choose from, instead of one pre-built level
  
  4. Proper inventory system, with more dynamic and variable items that could be picked up
     and used by the player to augment gameplay
     
  5. A form of infinite play mode, where the computer randomly generates rooms and the player 
     continually moves from room to room, keeping inventory, until they hit a game over screen.
