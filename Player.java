import java.util.ArrayList;
public class Player extends Participant{

  public Player(){
    super();
  }

  public boolean select(int i, Deck curr){
    Card val = hand.get(i);
    // checks to see if the selected card is valid compared to the previous one
    if ( val.isValid( curr ) ){
      System.out.println( "You " + toString() + " play " + val + " on " + curr.peekTop() );
      curr.useCard( hand.remove(i) );
      return true;
    }
    else {
      System.out.println("This card is not valid." );
    }
    return false;
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
    //
    // for (int i = 0; i < 5; i++){
    //   testPlayer.draw( testDeck.draw() );
    //   testBot.draw( testDeck.draw() );
    // }
    //
    // for (int j = 0; j < 6; j++){
    //   testBot.select( testDeck );
    //   testPlayer.select(0, testDeck);

    }

  }

}
