public class HvitResept extends Resept {

  private String farge;
  public HvitResept(Legemiddel legemiddel, Lege lege, int pasientId, int reit) {
    super(legemiddel, lege, pasientId, reit);
    this.farge = "Hvit";
  }

  public String farge() {
    return farge;
  }

  //betaler full pris
  public double prisAaBetale() {
    return 1 * legemiddel.hentPris();
  }

  //overrider toStrin metoden
  public String toString() {
    return String.format("[%d] [%d] %s %s %d %s", id, pasientId, legemiddel, lege.hentNavn(), reit, farge);
  }

}
