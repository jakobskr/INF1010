public class SortRute extends Rute {

  public SortRute(int x, int y, Labyrint maze) {
    super(x ,y ,maze);
  }

  public char tilTegn(){
    return '#';
  }

  public String toString() {
    return ("Sort Kol: " + x + " Rad : " + y);
  }

}
