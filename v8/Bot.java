/*
Team Mamba: Prattay Dey, Kartik Vanjani, Nafiz Labib
APCS PD8
FP
??-06-2022
*/
public class Bot extends Participant{
  private String name;

  public Bot(String name){
    super();
    this.name = name;
  }

  public void select(Deck curr){
    boolean canPlay = false;
    for (int i = 0; i < hand.size(); i++){
      Card card = hand.get(i);
      // finds the first valid card and selects it
      if ( card.isValid(curr) ){
        System.out.println( name + " " + toString() + " plays " + card + " on " + curr.peekTop() );
        curr.useCard( hand.remove(i) );
        canPlay = true;
        break;
      }
    }
    if (canPlay == false){
      //else, if no valid cards in hand --> draw a card
      draw( curr );
      System.out.println(name + " cannot play a card from their hand.");
      System.out.println(name + " has drawn a " + hand.get( hand.size() - 1) );
    }
  }

  public void draw( Deck curr ){
    hand.add( curr.draw() );
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
