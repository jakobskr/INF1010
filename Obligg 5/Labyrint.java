import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Labyrint {
  private Rute[][] ruteArray;
  private int hoyde,bredde;
  Koe<Stabel<Rute>> utveier;
  private boolean minimalUtskrift = false;

  private Labyrint (char[][] array) {
    ruteArray = new Rute[array.length][array[0].length];
    this.hoyde = array.length;
    this.bredde = array[0].length;

    for (int y = 0; y < ruteArray.length; y++) {
      for (int x = 0; x < ruteArray[y].length; x++ ) {
        if (array[y][x] == '#') {
          ruteArray[y][x] = new SortRute(x,y,this);
        }

        else if (array[y][x] == '.' && aapning(x,y)) {
          ruteArray[y][x] = new Aapning(x,y,this);
        }
        else {
          ruteArray[y][x] = new HvitRute(x,y,this);
        }
      }
    }
    for (Rute[] s : ruteArray) {
      for (Rute rute : s) {
        rute.settNaboer();
      }
    }
  }

  public void settMinimalUtskrift() {
    minimalUtskrift = true;
  }

  public String toString() {
    String labyrint = "";
    for (int y = 0; y < ruteArray.length; y++) {
      for (int x = 0; x < ruteArray[y].length; x++) {
        if(ruteArray[y][x] != null) {
          labyrint = labyrint + ruteArray[y][x].tilTegn();
        }
      }
      labyrint = labyrint + "\n";
    }
    return labyrint;
  }

  public static Labyrint lesFraFil(File fil) throws FileNotFoundException {
    Scanner filScan = new Scanner(fil);
    int yy = filScan.nextInt();
    int xx = filScan.nextInt();
    char[][] array = new char[yy][xx];
    int y = 0;
    char[] arr = filScan.nextLine().toCharArray();
    while(filScan.hasNextLine()) {
      arr = filScan.nextLine().toCharArray();
      for (int x = 0; x < array[y].length; x++) {
          array[y][x] = arr[x];
      }
      y++;
    }

    return new Labyrint(array);
  }

  private boolean aapning(int x, int y) {
    if (x == 0 || y == 0 || x == bredde - 1|| y == hoyde - 1) {
      return true;
    }
    else return false;
  }

  public Rute hentRute(int x, int y) {
    if(x <= 0 || y <=0 || y > hoyde || x > bredde) {
      return null;
    }
    else {
      return ruteArray[y - 1][x - 1];
    }
  }

  public Koe<Stabel<Rute>> finnUtveiFra(int kol, int rad) {
    utveier = new Koe<Stabel<Rute>>();
    if(kol <= 0 || rad <=0 || rad > hoyde || kol > bredde) {
      System.out.println("Feil argumenter");
      return null;
    }

    else {
      ruteArray[rad - 1][kol - 1].finnUtvei(minimalUtskrift);
    }
    System.out.println(utveier.storrelse());
    return utveier;
  }

  public void leggTilIListe(Stabel<Rute> utvei) {
    utveier.settInn(utvei);
  }

  public void tegnUtveier() {
    if (utveier.erTom()) {
      return;
    }
    for (Stabel<Rute> stabel : utveier) {
      String labyrint = "";
      for (int y = 0; y < ruteArray.length; y++) {
        for (int x = 0; x < ruteArray[y].length; x++) {
          if (stabel.contains(ruteArray[y][x])) {
            labyrint = labyrint + "*";
          }
          else  {
            labyrint = labyrint + ruteArray[y][x].tilTegn();
          }
        }
        labyrint = labyrint + "\n";
      }
      System.out.println(labyrint);
    }
  }

}//lukker klassen
