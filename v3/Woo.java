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

    // sets up the hand of each participant at the start of a game
    while ( it.hasNext() ){
      Participant participant = it.next();
      participant.setup( deck );
    }

    

  }
}
