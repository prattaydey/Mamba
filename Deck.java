/*
108 cards, 4 colors
Each color: one card for 0 / two cards each for 1-9 / two DrawTwo cards / two Skips / two Reverse
Four Wild cards and Four WildFour cards in entire Deck
*/

import java.util.Stack;

public class Deck{
  private Card[] cards;
  private Stack<Card> cardsInDeck;

  public Deck(){
    cards = new Card[108];

    // add cards with zero values
    for(int i = 0; i < 5; i++){
      cards[i].setValue(0);
      cards[i].setColor(i);
    }

    // add cards with 1 - 9 values
    for (int i = 5; i < 10; i++){
      
    }
  }


  public void reset(){

  }

  public void shuffle(){

  }
}
