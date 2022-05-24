public class Table{
  private int numSeats;
  private int time;

  public Table(int seats){
    numSeats = seats;
    time = 0;
  }

  public int setTime(int time){
    this.time = time;
  }

  public int compareTo(Table other){
    return this.time > other.time;
  }
/* ------------ ACCESSOR METHODS ------------- */
  public int getSeats(){ return numSeats; }

  public int getTime(){ return time; }



}
