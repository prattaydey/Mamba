import java.util.ArrayList;

public class Player extends Participant{

  public Player(){
    super();
  }

  public boolean select(int i, Deck curr){
    Card val = hand.get(i);
    // checks to see if the selected card is valid compared to the previous one
    if ( val.isValid( curr ) ){
      curr.useCard( hand.remove(i) );
      return true;
    }
    else {
      System.out.println("This card is not valid. Please pick another card from your hand OR draw a card from the deck");
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
    // Player testHand = new Player();
    // Deck testDeck = new Deck();
    //
    // for (int i = 0; i < 4; i++){
    //   testHand.draw( testDeck.draw() );
    // }
    //
    // System.out.println( testHand );
    //
    // testHand.select(3, testDeck);
    //
    // System.out.println( testDeck.peekTop() );
    //
    // testHand.select(0, testDeck);
    //
    // System.out.println( testDeck.peekTop() );
  }

}
