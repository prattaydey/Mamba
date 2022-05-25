import java.util.Arrays;

public class Card{

  private final String value;
  private final String color;

  private final String[] allValues =
  { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "DrawTwo", "Skip", "Reverse", "Wild", "WildFour" };

  private final String[] allColors = { "Red", "Green", "Blue", "Yellow", "Wild" };

  public Card(int number, int color){
    this.value = allValues[number];
    this.color = allColors[color];
  }

  public String getValue(){ return value; }

  public String getColor(){ return color; }

  public boolean isValid(Card previous){
    return this.getValue().equals( previous.getValue() )
        || this.getColor().equals( previous.getColor() )
        || this.getColor().equals( "Wild" )
        || this.getColor().equals( "WildFour" );
  }

}
