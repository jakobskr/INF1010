public class Lege implements Comparable<Lege> {

  private String navn;
  private Koe<Resept> reseptListe = new Koe<Resept>();

  //konstruktoren for lege
  public Lege(String navn) {
    this.navn = navn;
  }

  public String hentNavn() {
    return navn;
  }

  public int compareTo(Lege annenLege) {
    return this.navn.compareTo(annenLege.hentNavn());
  }

  public void leggTilResept(Resept resept) {
    reseptListe.settInn(resept);
  }

  public Koe<Resept> hentReseptliste() {
    return reseptListe;
  }

  //overider toString metoden for lege
  public String toString() {
    return String.format("%s, 0", navn);
  }

}
