public class Player{
  private ArrayList<Card> hand;

  public Player(){
    hand = new ArrayList<Card>();
  }

  public Card select(index i){
    return hand.remove(i);
  }

  

}
