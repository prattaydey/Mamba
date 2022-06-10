/*
Team Mamba: Prattay Dey, Kartik Vanjani, Nafiz Labib
APCS PD8
FP
??-06-2022
*/
public class Bot extends Participant{
  private String name;
  private String direction;

  public Bot(String name){
    super();
    this.name = name;
    direction = "FORWARD";
  }

  public void select(Deck curr){
    boolean canPlay = false;
    for (int i = 0; i < hand.size(); i++){
      Card card = hand.get(i);
      // finds the first valid card and selects it
      if ( card.isValid(curr) ){

        if ( card.getColor().equals("Wild") ){
          // range of 0-3 inclusive
          int newColor = (int) ( Math.random() * 4 );
          card.setColor( newColor );
        }

        System.out.println( name + " plays " + card + " on " + curr.peekTop() + ". Has " + ( hand.size() - 1 ) + " cards left." );
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
    if ( curr.isEmpty() ){
      curr.remix();
    }
    hand.add( curr.draw() );
  }

  // Don't want the player to see the bot's hand
  public String toString(){
    return name;
  }


}
