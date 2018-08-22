public abstract class Rute {
  protected int x,y;
  protected Labyrint maze;
  protected Rute north,south,east,west;
  protected Rute[] naboer = new Rute[4];
  //protected Stabel<Rute> paaVeien = new Stabel<Rute>();

  Rute(int x, int y, Labyrint maze) {
    this.x = x + 1;
    this.y = y + 1;
    this.maze = maze;
  }

  public abstract char tilTegn();

  void finnUtvei(boolean b) {
    gaa(b);
  }

  public String hentKordinater() {
    return (x + " " + y);
  }

  public int getY() {
    return y;
  }

  public int getX() {
    return x;
  }

  public void gaa(boolean b) {
    Stabel<Rute> veien = new Stabel<Rute>();
    veien.settInn(this);
    if(this instanceof Aapning) {
      if (!b) {
        System.out.println("fant veien");
      }
      maze.leggTilIListe(veien);
    }

    else if(this instanceof SortRute) {
      System.out.println("du har ikke lov til aa veere her");
    }

    else {

      for (Rute r: naboer) {
        if (r instanceof HvitRute) {
          r.gaa(this,veien,b);
        }
      }

      if (!b) {
        System.out.println("fant alle veier");
      }
    }
  }

  public void settNaboer() {
    naboer[0] = maze.hentRute(x - 1, y);
    naboer[1] = maze.hentRute(x, y - 1);
    naboer[2] = maze.hentRute(x + 1, y);
    naboer[3] = maze.hentRute(x, y + 1);

    }

  public void skrivNabo(){
    for (Rute sample : naboer) {
      System.out.println(sample);
    }
  }

  public void gaa(Rute forrige, Stabel<Rute> vei, boolean b) {
    Stabel<Rute> veien = vei.kopierLenkeListe();
    veien.settInn(this);

    if(this instanceof Aapning) {
      if (!b) {
        System.out.println("fant veien " + x + " " + y);
        //System.out.println(veien.storrelse());

      }
      maze.leggTilIListe(veien);
    }

    else if(this instanceof SortRute) {
      System.out.println("du har ikke lov til aa veere her");
    }

    else {

        for (Rute r : naboer) {
          if (r != forrige && r instanceof HvitRute && !veien.contains(r) ) {
            r.gaa(this, veien, b);
          }
        }
    }
  }

}
