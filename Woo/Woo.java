/*
Team Mamba: Prattay Dey, Kartik Vanjani, Nafiz Labib
APCS PD8
FP
??-06-2022
*/
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Woo{
  private Deck deck;
  private int numBots;
  private Deque<Participant> totalParticipants;
  private Player user;
  private String[] direction = {"FORWARDS", "BACKWARDS"};

  private InputStreamReader isr;
  private BufferedReader in;


  public Woo(){
    deck = new Deck();
    numBots = 1;
    totalParticipants = new ArrayDeque<Participant>();
    user = new Player();
    isr = new InputStreamReader(System.in);
    in = new BufferedReader(isr);
  }

  public void welcome(){
    System.out.println("Welcome to Team Mamba's UNO card game. \nHow many bots do you want to play with? (1-3)");
    try {
      numBots = Integer.parseInt(in.readLine());
    }
    catch ( IOException e ) { }
    if (numBots > 0 && numBots < 4){
      System.out.println("Now playing with " + numBots + " bots.");
    }
    else{
      System.out.println("Invalid number of bots! Automatically playing against one bot.");
    }

    // adds all the participants, including player and her bots
    totalParticipants.add( user );
    for (int i = 0; i < numBots; i++){
      totalParticipants.add(new Bot("Bot " + (i + 1)));
    }

    // sets up the hand of each participant at the start of a game
    // while ( it.hasNext() ){
    //   Participant p = it.next();
    //   p.setup( deck );
    // }

    for (Participant p : totalParticipants){
      p.setup(deck);
    }
  }

  public void playTurns(){
    boolean cardPlayed = false;

    for (Participant participant : totalParticipants) {
      // checks to see if next participant is either a Player or a bot
      // Participant participant = it.next();
      if ( participant instanceof Bot ){
        Bot bot = (Bot) participant;
        bot.select( deck );
      }
      else{
        user = (Player) participant;

        while ( cardPlayed == false ){
          System.out.println( "The top of the deck is " + deck.peekTop() );
          System.out.println("Your hand is " + participant);
          System.out.println("Choose what card you would like to select (1 - " + (participant.size() ) + ") " + "OR draw from the deck (0)" );

          int cardIndex = 0;
          try {
            cardIndex = Integer.parseInt(in.readLine());
          }
          catch ( IOException e ) { }

          // if input is 0, draw a card from deck
          if (cardIndex == 0){
            user.draw(deck);
            cardPlayed = true;
          }
          else if (cardIndex > 0 && cardIndex < user.size() ){
            // else if index is valid, selects the inputted index
            // if not valid, repeats the loop and asks for another input
            cardPlayed = user.select(cardIndex, deck);
          }
        }
      }
    }
  }

  public void game(){
    boolean canPlay = true;
    welcome();
    // runs until there is a clear winner
    // checks the size of each participant's hand & if it is empty
    while ( canPlay ){
      playTurns();
      for (Participant p : totalParticipants){
        if (p.size() == 0 && p instanceof Bot){
          System.out.println("Sorry, but you have lost.");
          canPlay = false;
        }
        if (p.size() == 0 && p instanceof Player){
          System.out.println("Congratulations! You have won the game.");
          canPlay = false;
      }
     }
    }
  }




  public static void main(String[] args){
    Woo testGame = new Woo();
    testGame.game();
  }
}
