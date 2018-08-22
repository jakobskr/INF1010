public class LegemiddelB extends Legemiddel {

  private int styrke;
  //har en ekstra parameter
  public LegemiddelB(String navn, double pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public int hentVanedannendeStyrke() {
    return styrke;
  }
}
