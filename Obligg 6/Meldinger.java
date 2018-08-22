import java.util.concurrent.locks.*;
//import java.util.concurrent.locks.Condition;

public class Meldinger extends OrdnetLenkeliste<Melding> {
  //private LenkeListe<String> meldinger = new LenkeListe<String>();
  Lock laas =	new ReentrantLock();
  Lock utlaas = new ReentrantLock();
  private final Condition erTom = utlaas.newCondition();

  public void settInn(Melding s) {
    laas.lock();
    try {
      super.settInn(s);
    }
    finally {
      laas.unlock();
    }
  }

  public Melding hentMelding() {
    Melding melding;

      laas.lock();
      try {
        melding = super.fjern();
      }
      finally {
        laas.unlock();
      }
    return melding;
  }

}
