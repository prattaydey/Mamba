/*
Team Mamba: Prattay Dey, Nafiz Labib, Kartik Vanjani
APCS PD8
FP
2022-06-10F
*/
/*
108 cards, 4 colors
Each color: one card for 0 / two cards each for 1-9 / two DrawTwo cards / two Skips / two Reverse
Four Wild cards and Four WildFour cards in entire Deck
*/

import java.util.Collections;
import java.util.Stack;

public class Deck{
  private Stack<Card> deck; // pile that you draw from
  private Stack<Card> usedDeck; // pile that all the players stack onto

  private int dupliZero = 1; // number of duplicate zeroes for each color
  private int dupliNonZero = 2; // number of duplicate nonzeroes for each colors


  public Deck(){
    deck = new Stack<Card>();
    usedDeck = new Stack<Card>();
    fillDeck();
    shuffle();
    useCard( draw() );
  }

  public void fillDeck(){
    for (int i = 0; i < dupliZero; i++){
      deck.push( new Card(0, "Red" ) );
      deck.push( new Card(0, "Green" ) );
      deck.push( new Card(0, "Blue" ) );
      deck.push( new Card(0, "Yellow" ) );
    }

    for (int j = 1; j < 10; j++){
      for (int i = 0; i < dupliNonZero; i++){
        deck.push( new Card(j, "Red" ) );
        deck.push( new Card(j, "Green" ) );
        deck.push( new Card(j, "Blue" ) );
        deck.push( new Card(j, "Yellow" ) );
      }
    }

    for (int i = 0; i < 2; i++ ){
      // adds all the DrawTwo
      deck.push( new Card(10, "Red" ) );
      deck.push( new Card(10, "Green" ) );
      deck.push( new Card(10, "Blue" ) );
      deck.push( new Card(10, "Yellow" ) );

      // adds all the Skips
      deck.push( new Card(11, "Red" ) );
      deck.push( new Card(11, "Green" ) );
      deck.push( new Card(11, "Blue" ) );
      deck.push( new Card(11, "Yellow" ) );

      // adds all the Reverse
      deck.push( new Card(12, "Red" ) );
      deck.push( new Card(12, "Green" ) );
      deck.push( new Card(12, "Blue" ) );
      deck.push( new Card(12, "Yellow" ) );
    }

    for (int i = 0; i < 4; i++ ){
      // adds all the Wilds
      deck.push( new Card(13, "Wild" ) );
      deck.push( new Card(13, "Wild" ) );
      deck.push( new Card(13, "Wild" ) );
      deck.push( new Card(13, "Wild" ) );

      // adds all the WildFour
      deck.push( new Card(14, "Wild" ) );
      deck.push( new Card(14, "Wild" ) );
      deck.push( new Card(14, "Wild" ) );
      deck.push( new Card(14, "Wild" ) );
    }
  }

  public void shuffle(){
    Collections.shuffle(deck);
  }

  // when player draws a card, remove it from the deck
  public Card draw(){
    if ( deck.isEmpty() ){
      remix();
    }
    return deck.pop();
  }

  // when player selects a card, add it to the current pile of used cards
  public void useCard(Card c){
    usedDeck.push(c);
  }

  // used to see the latest card that was given
  public Card peekTop(){
    return usedDeck.peek();
  }

  // if deck is empty, reuse old cards in the deck and shuffle
  public void remix(){
    while ( !usedDeck.isEmpty() ){
      deck.push( usedDeck.pop() );
      shuffle();
    }
  }

  public boolean isEmpty(){ return deck.isEmpty(); }

  public static void main(String[] args){
    // test for shuffle
    Deck test = new Deck();
    System.out.println( test.draw() );
  }
}
