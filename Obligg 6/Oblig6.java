import krypto.*;
import java.util.concurrent.locks.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Oblig6 {
  public static void main(String [] args) throws Exception {
    Operasjonssentral ops = new Operasjonssentral(6);
    Kanal[] kanaler = ops.hentKanalArray();
    System.out.println(kanaler.length);
    Telegrafist[] telegrafister = new Telegrafist[kanaler.length];
    Meldinger meldinger = new Meldinger();
    Meldinger ferdigemeldinger = new Meldinger();
    ThreadGroup telefolk = new ThreadGroup("telefolk");
    ThreadGroup kryptfolk = new ThreadGroup("kryptfolk");

    for (int i = 0;i < kanaler.length ;i++ ) {
      telegrafister[i] = new Telegrafist(telefolk, "telegraf", kanaler[i], meldinger);
    }
    for (Telegrafist sample: telegrafister) {
      sample.start();
    }

    Kryptering[] krypt = new Kryptering[30];
    for (int i = 0;i < krypt.length ;i++ ) {
      krypt[i] = new Kryptering(kryptfolk, meldinger, ferdigemeldinger, telefolk);
    }

    for (Kryptering sample : krypt) {
      sample.start();
    }
    while(true){
      if (telefolk.activeCount() == 0 && kryptfolk.activeCount() == 0) {
        break;
      }
    }

    System.out.println(meldinger.storrelse());
    System.out.println(ferdigemeldinger.storrelse());

    String[] tekster = new String[kanaler.length];
    File utfil = new File("C:/Users/Jakob/Google Drive/inf1010/Obligg 6/utfil.txt");
    File utfil1 = new File("C:/Users/Jakob/Google Drive/inf1010/Obligg 6/utfil1.txt");
    File utfil2 = new File("C:/Users/Jakob/Google Drive/inf1010/Obligg 6/utfil2.txt");
    PrintWriter ut = new PrintWriter(utfil, "utf-8");
    PrintWriter ut2 = new PrintWriter(utfil1, "utf-8");
    PrintWriter ut3 = new PrintWriter(utfil2, "utf-8");

    for (Melding s : ferdigemeldinger) {
      if (s.hentId() == 1) {
        ut.println(s);
        ut.println("\n");
      }
      if (s.hentId() == 2) {
        ut2.println(s);
        ut2.println("\n");
      }
      if (s.hentId() == 3) {
        ut3.println(s);
        ut3.println("\n");
      }
    }
    ut.close();
    ut3.close();
    ut2.close();

  }
}//lukker classen

class Telegrafist extends Thread {
  private int teller = 0;
  private Kanal kanal;
  Meldinger meldinger;
  Telegrafist(ThreadGroup gruppe, String name, Kanal k, Meldinger meldinger) {
    super(gruppe, name);
    this.kanal = k;
    this.meldinger = meldinger;
  }

  public void run() {
    while(true) {
      //System.out.println(kanal.hentId());
      String melding = kanal.lytt();
      if(melding != null) {
        meldinger.settInn(new Melding(teller, kanal.hentId(), melding));
        teller++;
      }
      else{
        System.out.println("jeg er ferdig hurra!");
        break;
      }
    }
  }
}

class Kryptering extends Thread {
  Meldinger uferdig, ferdig;
  ThreadGroup telefolk;
  Kryptering(ThreadGroup kryptering,Meldinger uferdig, Meldinger ferdig, ThreadGroup telefolk) {
    super(kryptering, "trad");
    this.uferdig = uferdig;
    this.ferdig = ferdig;
    this.telefolk = telefolk;
  }

  public void run() {
    while(telefolk.activeCount() > 0 || (uferdig.storrelse() > 0)) {
      //System.out.println(telefolk.activeCount() + " " + uferdig.storrelse());
      Melding melding = uferdig.hentMelding();
      if (melding != null) {
        melding.endreInnhold(Kryptografi.dekrypter(melding.toString()));
        ferdig.settInn(melding);
      }
    }
  }
}

 class Melding implements Comparable<Melding> {
   private int teller,kanalId;
   private String innhold;
   Melding(int teller, int kanalId, String melding) {
     this.teller = teller;
     this.kanalId = kanalId;
     this.innhold = melding;
   }

   public String toString() {
     return innhold;
   }

   public int hentId() {
     return kanalId;
   }

   public int hentTeller() {
     return teller;
   }

   public void endreInnhold(String s) {
     innhold = s;
   }

   public int compareTo(Melding meld) {
     if (kanalId == meld.hentId()) {
       return teller - meld.hentTeller();
     }
     return 1;
   }
 }
