abstract public class Legemiddel {

  //iden til dette objektet
  private int id;
  //holder styr over hvor mange objekter det finnes av denne klassen
  private static int globalid;
  private String navn;
  private double pris;
  private double virkestoff;

  public Legemiddel(String navn, double pris, double virkestoff) {
    this.navn = navn;
    this.pris = pris;
    this.virkestoff =virkestoff;
    this.id = globalid++;
  }

  public String toString() {
    return String.format("[%d] %s", id, navn);
  }

  public int hentId() {
    return id;
  }

  public String hentNavn() {
    return navn;
  }

  public double hentPris() {
    return pris;
  }

  public double hentVirkestoff() {
    return virkestoff;
  }
}
