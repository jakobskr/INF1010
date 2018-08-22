/*public abstract class Rute2 {
  protected int x,y;
  protected Labyrint maze;
  protected Rute2 north,south,east,west;
  protected Rute2[] naboer = new Rute[4];
  //protected Koe<Rute> paaVeien = new Koe<Rute>();

  Rute2(int x, int y, Labyrint maze) {
    this.x = x + 1;
    this.y = y + 1;
    this.maze = maze;
  }

  public abstract char tilTegn();

  void finnUtvei(String utvei, boolean b) {
    gaa(b);
  }

  public String hentKordinater() {
    return (x + " " + y);
  }

  public void gaa(boolean b) {
    Koe<Rute> veien = new Koe<Rute>();
    veien.settInn(this);
    if(this instanceof Aapning) {
      if (!b) {
        System.out.println("fant veien");
      }
    }



    else if(this instanceof SortRute) {
      System.out.println("du har ikke lov til aa veere her");
    }

    else {
      if (!b) {
        System.out.println(this);
      }

      for (Rute r: naboer) {
        if (r instanceof HvitRute) {
          System.out.println(r);
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

  public void gaa(Rute forrige, Koe<Rute> vei, boolean b) {
    Koe<Rute> veien = vei;
    vei.settInn(this);

    if(this instanceof Aapning) {
      if (!b) {
        System.out.println("fant veien " + x + " " + y);
        System.out.println(veien.storrelse());
        vei = new Koe<Rute>();
      }
      maze.leggTilIListe(veien.toString());
    }

    else if(this instanceof SortRute) {
      System.out.println("du har ikke lov til aa veere her");
    }

    else {

        for (Rute r : naboer) {
          if (r != forrige && r instanceof HvitRute && !vei.contains(r) ) {
            r.gaa(this, vei, b);
          }
        }
    }
  }

}*/
