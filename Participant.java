/*
Team Mamba: Prattay Dey, Kartik Vanjani, Nafiz Labib
APCS PD8
FP
??-06-2022
*/
import java.util.ArrayList;

public class Participant{
  protected ArrayList<Card> hand;

  public Participant(){
    hand = new ArrayList<Card>();
  }

  public void setup(Deck deck){
    for (int i = 0; i < 7; i++){
      hand.add( deck.draw() );
    }
  }


  public int size(){ return hand.size(); }
}
