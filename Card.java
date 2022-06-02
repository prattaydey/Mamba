/*
Team Mamba: Prattay Dey, Kartik Vanjani, Nafiz Labib
APCS PD8
FP
??-06-2022
*/
import java.util.Arrays;

public class Card{

  private String value;
  private String color;

  private final String[] allValues =
  { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "DrawTwo", "Skip", "Reverse", "Wild", "WildFour" };

  private final String[] allColors = { "Red", "Green", "Blue", "Yellow", "Wild" };

  public Card(int number, String color){
    this.value = allValues[number];
    this.color = color;
  }

  public void setValue(int index){
    value = allValues[index];
  }

  public void setColor(int index){
    color = allColors[index];
  }

  public String getValue(){ return value; }

  public String getColor(){ return color; }

  public boolean isValid(Deck curr){
    // check the previous card from the pile
    Card previous = curr.peekTop();
    return this.getValue().equals( previous.getValue() )
        || this.getColor().equals( previous.getColor() )
        || this.getColor().equals( "Wild" );
  }

  public String toString(){

    String retVal = "";
    if (color.equals("Red")) { retVal += "\u001b[31m"; }
    if (color.equals("Green")) { retVal += "\u001b[32m"; }
    if (color.equals("Blue")) { retVal += "\u001b[36m"; }
    if (color.equals("Yellow")) { retVal += "\u001b[33m"; }
    if (color.equals("Wild")) { retVal += "\u001b[37m"; }

    if (value.equals("Zero")) { retVal += "0"; }
    if (value.equals("One")) { retVal += "1"; }
    if (value.equals("Two")) { retVal += "2"; }
    if (value.equals("Three")) { retVal += "3"; }
    if (value.equals("Four")) { retVal += "4"; }
    if (value.equals("Five")) { retVal += "5"; }
    if (value.equals("Six")) { retVal += "6"; }
    if (value.equals("Seven")) { retVal += "7"; }
    if (value.equals("Eight")) { retVal += "8"; }
    if (value.equals("Nine")) { retVal += "9"; }

    if (value.equals("DrawTwo")) { retVal += "+2"; }
    if (value.equals("Skip")) { retVal += "S"; }
    if (value.equals("Reverse")) { retVal += "R"; }
    if (value.equals("Wild")) { retVal += "W"; }
    if (value.equals("WildFour")) { retVal += "W4"; }

    return retVal + "\u001b[0m";
  }

}
