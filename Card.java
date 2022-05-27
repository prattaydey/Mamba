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

  public boolean isValid(Card previous){
    return this.getValue().equals( previous.getValue() )
        || this.getColor().equals( previous.getColor() )
        || this.getColor().equals( "Wild" )
        || this.getColor().equals( "WildFour" );
  }

  public String toString(){
    return color + value;

    // String retVal = "";
    // if (color.equals("Red")) { retVal += "\033[31m"; }
    // if (color.equals("Green")) { retVal += "\033[32m"; }
    // if (color.equals("Blue")) { retVal += "\033[34m"; }
    // if (color.equals("Yellow")) { retVal += "\033[33m"; }
    // if (color.equals("Wild")) { retVal += "\033[1m"; }
    //
    // if (value.equals("Zero")) { retVal += "0"; }
    // if (value.equals("One")) { retVal += "1"; }
    // if (value.equals("Two")) { retVal += "2"; }
    // if (value.equals("Three")) { retVal += "3"; }
    // if (value.equals("Four")) { retVal += "4"; }
    // if (value.equals("Five")) { retVal += "5"; }
    // if (value.equals("Six")) { retVal += "6"; }
    // if (value.equals("Seven")) { retVal += "7"; }
    // if (value.equals("Eight")) { retVal += "8"; }
    // if (value.equals("Nine")) { retVal += "9"; }
    //
    // return retVal;
  }

}
