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
    return value + " " + color;
  }

}
