public class Fastlege extends Lege implements Kommuneavtale{
  private int avtaleNr;

  //fastlege har en esktra parameter
  public Fastlege(String navn, int avtaleNr) {
    super(navn);
    this.avtaleNr = avtaleNr;
  }

  //returnerer avtalenr
  public int hentAvtalenummer() {
    return avtaleNr;
  }

}
