class Legeliste extends OrdnetLenkeliste<Lege> {

  //sjekker om en lege finnes i systemet
  public Lege finnLege(String navn) {
    if(storrelse() == 0) {
      return null;
    }

    for (Lege lege: this ) {
      if (lege.hentNavn().toLowerCase().equalsIgnoreCase(navn.toLowerCase())) {
        return lege;
      }
    }

    return null;
  }

  //returner en array med alle navnene til legene
  public String[] stringArrayMedNavn() {
    String[] navnArray = new String[storrelse()];
    int teller = 0;
    for (Lege lege : this ) {
      navnArray[teller] = lege.hentNavn().toLowerCase();
      teller++;
    }
    return navnArray;
  }
}
