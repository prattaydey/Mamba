/*
Team Mamba: Prattay Dey, Nafiz Labib, Kartik Vanjani
APCS PD8
FP
2022-06-10F
*/

import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Player extends Participant{

  private InputStreamReader isr;
  private BufferedReader in;

  public Player(){
    super();
    isr = new InputStreamReader(System.in);
    in = new BufferedReader(isr);
  }

  public boolean select(int i, Deck curr){
    Card val = hand.get(i - 1);
    // checks to see if the selected card is valid compared to the previous one
    if ( val.isValid( curr ) ){

      // if card is a wild, asks the user which color they want to choose
      if ( val.getColor().equals("Wild") ){
        boolean validColor = false;

        while (validColor == false){
          int newColor = 0;
          System.out.println("Which color would you like to change it to?");
          System.out.println(" (1) Red \n (2) Green \n (3) Blue \n (4) Yellow");
          try {
            newColor = Integer.parseInt(in.readLine());
          }
          catch ( IOException e ) { }

          if (newColor > 0 && newColor < 5){
            val.setColor(newColor - 1);
            validColor = true;
          }
          else{
            System.out.println("This color is not valid. Please pick a valid number corresponding to the colors.");
          }
        }
      }

      System.out.println( "You " + toString() + " play " + val + " on " + curr.peekTop() );
      curr.useCard( hand.remove(i - 1) );
      return true;
    }
    else {
      System.out.println("This card is not valid. Pick another card or draw" );
      return false;
    }
  }

  public void draw( Deck curr ){
    if ( curr.isEmpty() ){
      curr.remix();
    }
    hand.add( curr.draw() );
    System.out.println("You drew " + hand.get(hand.size()-1));
  }


  public String toString(){
    String retVal = "[  ";
    for (int i = 0; i < size(); i++){
      retVal += hand.get(i) + "  ";
    }
    return retVal + "]";
  }

  public static void main(String[] args){
    // Player testPlayer = new Player();
    // Bot testBot = new Bot();
    // Deck testDeck = new Deck();
    //
    // testPlayer.setup( testDeck );
    // testBot.setup( testDeck );
    //
    // for (int j = 0; j < 6; j++){
    //   testBot.select( testDeck );
    //   testPlayer.select(0, testDeck);
    // }
  }
}
