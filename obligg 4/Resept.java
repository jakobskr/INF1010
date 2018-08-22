abstract public class Resept {

  //holder styr over hvor mange objekter det finnes av klassen
  protected static int globalid;
  //iden til objektet
  protected int id;
  protected Legemiddel legemiddel;
  protected Lege lege;
  protected int pasientId;
  protected int reit;

  //konstruktoren til resept
  public Resept(Legemiddel legemiddel, Lege lege, int pasientId, int reit) {
    this.id = globalid++;
    this.legemiddel = legemiddel;
    this.lege = lege;
    this.pasientId = pasientId;
    this.reit = reit;
  }

  public int hentId() {
    return id;
  }

  public Legemiddel hentLegemiddel() {
    return legemiddel;
  }

  public Lege hentLege() {
    return lege;
  }

  public int hentPasientId() {
    return pasientId;
  }

  public int hentReit() {
    return reit;
  }

 /**
  * Bruker resepten én gang. Returner false om resepten er
  * oppbrukt, ellers returnerer den true.
  * @return      om resepten kunne brukes
  */
  public boolean bruk() {

    if (reit > 0) {
      reit--;
      return true;
    }

    else {
      return false;
    }
  }

 /**
  * Returnerer reseptens farge. Enten "blaa" eller "hvit".
  * @return      reseptens farge
  */
  abstract public String farge();

 /**
  * Returnerer prisen pasienten maa betale.
  * @return      prisen pasienten maa betale
  */
  abstract public double prisAaBetale();

}
