import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Obligg2 {
  public static void main(String[] filter) throws Exception {
    ArrayList<Vehicle> liste = new ArrayList<Vehicle>();
    liste = lesFraFil("1in.txt", liste);
    skrivUt(liste, filter);

  }

  public static void skrivUt(ArrayList<Vehicle> liste, String[] filter) {

    if (filter.length == 0 || !filter[0].equalsIgnoreCase("EL") && !filter[0].equalsIgnoreCase("fossil")) {
      for (Vehicle sample: liste) {
          sample.info();
      }
    }

    else if (filter[0].equalsIgnoreCase("EL")) {
      for (Vehicle sample: liste) {
        if (sample instanceof ElBil) {
          sample.info();
        }
      }
    }

    else if (filter[0].equalsIgnoreCase("fossil")) {
      for (Vehicle sample: liste) {
        if (sample instanceof FossilBil) {
          sample.info();
        }
      }
    }

  }

  public static ArrayList<Vehicle> lesFraFil(String filnavn, ArrayList<Vehicle> liste) throws Exception {
    String next;
    String[] nextDelt;
    Scanner filScan= new Scanner(new File(filnavn));
    while (filScan.hasNextLine()) {
      next = filScan.nextLine();

      if(next.contains("EL")) {
        nextDelt = next.split(" ");
        liste.add(new ElBil(nextDelt[1], Double.parseDouble(nextDelt[2])));
      }

      else if (next.contains("LASTEBIL")) {
        nextDelt = next.split(" ");
        liste.add(new LasteBil(nextDelt[1], Double.parseDouble(nextDelt[2]), Double.parseDouble(nextDelt[3])));
      }

      else if (next.contains("PERSONBIL")) {
        nextDelt = next.split(" ");
        liste.add(new PersonBil(nextDelt[1], Double.parseDouble(nextDelt[2]), Integer.parseInt(nextDelt[3])));

      }

    }
    return liste;
  }

}
