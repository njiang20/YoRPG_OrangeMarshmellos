/**********************************************
 *
 * class YoRPG -- Driver file for Ye Olde Role Playing Game.
 * Simulates monster encounters of a wandering adventurer.
 * Required classes: Protagonist, Monster
 *
 * USAGE:
 * Compile. Note messages generated.
 * Devise a plan of attack with your trio.
 * Code incrementally, testing each bit of new functionality as you go.
 * The only modification you should make to this driver file is moving comment bar down in main method, and filling in DISCO/QCC
 * (If you feel other changes are merited, note what and why, so that we may discuss on the 'morrow.)
 *
 * Team Orange Marshmellows: Nina Jiang, Diana Akhmedova, Julia Kozak // Duckies: Miss Alpaca, Ajax, Flopsy
 * APCS pd08
 * L01 -- An Adventure is You!
 * 2021-11-23
 *
 * Time Spent: 2.5 hours
 *
 * DISCO:
 * - If you can solve the problem with a conditional, don't use an exception.
 * - When catching an exception, be sure to return something runnable in the "safe".
 * - public class Protagonist extends Character --> this means that Protagonist is a type Character.
 *     - It will inherit all the attributes and variables in Character.
 * - InputStreamReader: this converts byte streams to character streams of a specified charset/something readable, which can be specified by name. It is used to read characters from files where the text is represented by bytes.
 * - BufferedReader: this reads a sequence of characters, so it should be used for multiple threads. It's a bit faster when compared to Scanner since it has more memory.
 * - IOException: this happens when there is a failed input or output.
 *
 * QCC:
 * - What do BufferedReader and InputStreamReader do? How are they different from a Scanner?
 * - Is it preferable to use protected visibility variables, or accessor methods with extension classes? Which one is more efficient?
 *
 * OUR DRIVER MODS:
 * - We included an if-else statement for character selection so the character has the option to initialize a certain type of protagonist.
 * - A random int is created to have a random type of monster approach the character.
 * - We have the option to view an "about" page before a turn starts, which prints the about methods for each type of character.
 *
 **********************************************/

import java.io.*;
import java.util.*;

public class YoRPG {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 5;

  //each round, a Protagonist and a Monster will be instantiated...
  private Protagonist pat;
  private Monster smaug;

  private int moveCount;
  private boolean gameOver;
  private int difficulty;
  private int charSelect;
  private String choice;

  private InputStreamReader isr;
  private BufferedReader in;
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
  public YoRPG() {
    moveCount = 0;
    gameOver = false;
    isr = new InputStreamReader( System.in );
    in = new BufferedReader( isr );
    newGame();
  }
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

  /*=============================================
    void newGame() -- gathers info to begin a new game
    pre:
    post: according to user input, modifies instance var for difficulty
    and instantiates a Protagonist
    =============================================*/
  public void newGame() {
    String s;
    String name = "";
    s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

    s += "\nChoose your difficulty: \n";
    s += "\t1: Easy\n";
    s += "\t2: Not so easy\n";
    s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    s += "Selection: ";
    System.out.print( s );

    try {
	    difficulty = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }

    s = "\nChoose your character:\n";
    s += "\t1: Swordsman\n\t2: Archer\n\t3: Wizard\n";
    s += "Selection: ";
    System.out.print( s );

    try {
	    charSelect = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }

    s = "\nIntrepid protagonist, what doth thy call thyself? (State your name): ";
    System.out.print( s );

    try {
            name = in.readLine();
    }
    catch ( IOException e ) { }

    s = "\nWould thou likest to view the treasured abouteth scripture? (Y/N)\n";
    s += "Selection: ";
    System.out.print( s );

    try {
	    choice = in.readLine();
    }
    catch ( IOException e ) { }

    if( choice.equals("Y") ) {
      System.out.println(Swordsman.about());
      System.out.println(Archer.about());
      System.out.println(Wizard.about());
      System.out.println(Slime.about());
      System.out.println(Goblin.about());
      System.out.println(Dragon.about());
    }

    //instantiate the player's character
    if ( charSelect == 1 ) {
      pat = new Swordsman( name );
    }
    else if ( charSelect == 2 ) {
      pat = new Archer( name );
    }
    else {
      pat = new Wizard( name );
    }

  }//end newGame()


  /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    post: Returns true if player wins (monster dies).
    Returns false if monster wins (player dies).
    =============================================*/
  public boolean playTurn() {

    int i = 1;
    int d1, d2;

    if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
    else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

	    int monsterSelect = (int)(Math.random() * 3);
	    if( monsterSelect == 1 ) {
	        smaug = new Slime();
		System.out.println( "Halt! A smile hath approcheth you!" );
	    }
	    else if( monsterSelect == 2 ) {
		smaug = new Goblin();
                System.out.println( "Beware! A goblin spotted thou in the bushes!" );
	    }
	    else {
		smaug = new Dragon();
                System.out.println( "Uh oh... a dragon?! Good luck, traveler, thou will need it..." );
	    }

	    while( smaug.isAlive() && pat.isAlive() ) {

        // Give user the option of using a special attack:
        // If you land a hit, you incur greater damage,
        // ...but if you get hit, you take more damage.
        try {
          System.out.println( "\nDo you feel lucky?" );
          System.out.println( "\t1: Nay.\n\t2: Aye!" );
          i = Integer.parseInt( in.readLine() );
        }
        catch ( IOException e ) { }

        if ( i == 2 )
          pat.specialize();
        else
          pat.normalize();

        d1 = pat.attack( smaug );
        d2 = smaug.attack( pat );

        System.out.println( "\n" + pat.getName() + " dealt " + d1 +
                            " points of damage.");

        System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
                            " for " + d2 + " points of damage.");
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
        System.out.println( "'Twas an epic battle, to be sure... " +
                            "You cut ye olde monster down, but " +
                            "with its dying breath ye olde monster. " +
                            "laid a fatal blow upon thy skull." );
        return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
        System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
        return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
        System.out.println( "Ye olde self hath expired. You got dead." );
        return false;
	    }
    }//end else

    return true;
  }//end playTurn()
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  public static void main( String[] args ) {
    //As usual, move the begin-comment bar down as you progressively
    //test each new bit of functionality...

    //loading...
    YoRPG game = new YoRPG();

    int encounters = 0;
    while( encounters < MAX_ENCOUNTERS ) {
    if ( !game.playTurn() )
    break;
    encounters++;
    System.out.println();
    }

    System.out.println( "Thy game doth be over." );
    /*================================================
	  ================================================*/
  }//end main

}//end class YoRPG
