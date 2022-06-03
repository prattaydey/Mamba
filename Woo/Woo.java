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
import java.util.Iterator;

public class Woo{
  private Deck deck;
  private int numBots;
  private ArrayList totalParticipants;
  private Participant[] totalBots;
  private Participant user;
  private Iterator<Participant> it;

  private InputStreamReader isr;
  private BufferedReader in;


  public Woo(){
    deck = new Deck();
    numBots = 0;
    totalParticipants = new ArrayList<Participant>();
    totalBots = new Bot[0];
    user = new Player();

    // will be used to facilitate each participant's turns
    it = totalParticipants.iterator();

    isr = new InputStreamReader(System.in);
    in = new BufferedReader(isr);
  }

  public void welcome(){
    System.out.println("Welcome to Team Mamba's UNO card game. \n How many bots do you want to play with? (1-3)");
    try {
      numBots = Integer.parseInt(in.readLine());
    }
    catch ( IOException e ) { }
    if (numBots > 0 && numBots < 4){
      totalBots = new Bot[numBots];
    }
    else{
      System.out.println("Invalid number of bots! Automatically playing against one bot.");
      totalBots = new Bot[1];
    }

    // adds all the participants, including player and her bots
    totalParticipants.add( user );
    for (int i = 0; i < totalBots.length; i++){
      totalParticipants.add( totalBots[i] );
    }

    // sets up the hand of each participant at the start of a game
    while ( it.hasNext() ){
      Participant participant = it.next();
      participant.setup( deck );
    }
  }

  public void turns(){
    while ( it.hasNext() ){
      // checks to see if next participant is either a Player or a bot
      Participant participant = it.next();
      if ( participant instanceof Bot ){
        participant = (Bot) participant;
        participant.select( deck );
      }
      else{
        participant = (Player) participant;
        System.out.println("Your hand is " + participant);
        System.out.println("Choose what card you would like to select (1 - " + participant.size() + 1 + ") " + "OR draw from the deck" );
      }

    }
  }


  public static void main(String[] args){

  }
}
