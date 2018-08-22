public class LegemiddelA extends Legemiddel {

  private int styrke;
    //har en ekstra parameter
   public LegemiddelA(String navn, double pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public int hentNarkotiskStyrke() {
    return styrke;
  }
}
