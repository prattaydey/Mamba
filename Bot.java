/*
Team Mamba: Prattay Dey, Kartik Vanjani, Nafiz Labib
APCS PD8
FP
??-06-2022
*/
public class Bot extends Participant{

  public Bot(){
    super();
  }

  public void select(Deck curr){
    boolean canPlay = false;
    for (int i = 0; i < hand.size(); i++){
      Card card = hand.get(i);
      // finds the first valid card and selects it
      if ( card.isValid(curr) ){
        System.out.println( "Bot " + toString() + " plays " + card + " on " + curr.peekTop() );
        curr.useCard( hand.remove(i) );
        canPlay = true;
        break;
      }
    }
    if (canPlay == false){
      //else, if no valid cards in hand --> draw a card
      draw( curr );
      System.out.println("Bot has to draw " + hand.get( hand.size() - 1) );
    }
  }

  public void draw( Deck curr ){
    hand.add( curr.draw() );

    // checks to see if the new drawn card is able to be put on the pile
    Card newCard = hand.get( hand.size() - 1);
    if ( newCard.isValid (curr) ){
      curr.useCard( newCard );
    }
  }

  // will be changed later
  public String toString(){
    String retVal = "[  ";
    for (int i = 0; i < size(); i++){
      retVal += hand.get(i) + "  ";
    }
    return retVal + "]";
  }


}
