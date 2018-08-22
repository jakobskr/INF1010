public class HvitRute extends Rute {

  public HvitRute(int x, int y, Labyrint maze) {
    super(x,y,maze);
  }

  public char tilTegn() {
    return '.';
  }

  public String toString() {
    return "Hvit Kol: " + x + " Rad : " + y;
  }
}
