import java.util.ArrayList;

public class Participant{
  protected ArrayList<Card> hand;

  public Participant(){
    hand = new ArrayList<Card>();
  }

  public void draw(Card c){
    hand.add(c);
  }

  public int size(){ return hand.size(); }
}
