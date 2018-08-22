public class Pasient {

  //holder styr over hvor mange objekter det er av denne klassen
  private static int globalid;
  //id'en til objektet
  private int id;
  private String navn;
  private long fodselsnummer;
  private String gateadresse;
  private int postnummer;
  private Stabel<Resept> reseptListe = new Stabel<Resept>();

  public Pasient() {}

  //konstruktoren til pasient
  public Pasient(String navn, long fodselsnummer, String gateadresse, int postnummer) {
    this.id = globalid++;
    this.navn = navn;
    this.fodselsnummer = fodselsnummer;
    this.gateadresse = gateadresse;
    this.postnummer = postnummer;
  }

  //overider toString for pasient
  public String toString() {
    return String.format("[%d] %s (%d)", id, navn, fodselsnummer);
  }

  public int hentId() {
    return id;
  }

  public String hentNavn() {
    return navn;
  }

  public long hentFodselsnummer() {
    return fodselsnummer;
  }

  public String hentGateadresse() {
    return gateadresse;
  }

  public int hentPostnummer() {
    return postnummer;
  }

  public void leggTilResept(Resept resept) {
    reseptListe.settInn(resept);
  }

  //reseptlisten til pasient
  public Stabel<Resept> hentReseptliste() {
    return reseptListe;
   }
}
