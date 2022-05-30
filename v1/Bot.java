public class Bot extends Participant{

  public Bot(){
    super();
  }

  public void select(Deck curr){
    for (int i = 0; i < hand.size(); i++){
      Card card = hand.get(i);
      // finds the first valid card and selects it
      if ( card.isValid(curr) ){
        System.out.println( "Bot " + toString() + " plays " + card + " on " + curr.peekTop() );
        curr.useCard( hand.remove(i) );
        break;
      }
    }
    //else, if no valid cards in hand --> draw a card
    draw( curr.draw() );
    System.out.println("Bot has to draw " + hand.get( hand.size() - 1) );
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
