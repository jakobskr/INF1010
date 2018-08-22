public class BlaaResept extends Resept {

  private String farge;


  public BlaaResept(Legemiddel legemiddel, Lege lege, int pasientId, int reit) {
    super(legemiddel, lege, pasientId, reit);
    this.farge = "Blaa";
  }

  public String farge() {
    return "Blaa";
  }

  //blaa resept koster mindre
  public double prisAaBetale() {
    return 0.25 * legemiddel.hentPris();
  }

  //overider toString for blaaresept
  public String toString() {
    return String.format("[%d] [%d] %s %s %d %s", id, pasientId, legemiddel, lege.hentNavn(), reit, farge);
  }

}
