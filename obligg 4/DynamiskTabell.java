@SuppressWarnings("unchecked")
//en tabell som oker kapasiteten etterhvert som det trengs
public class DynamiskTabell<T> extends StatiskTabell<T> {

  //tabellen defaulter til 50 med mindre noe annet blir oppgitt
  public DynamiskTabell () {
    super(50);
  }

  public DynamiskTabell (int size) {
    super(size);
  }

  @Override
  //setter inn et element paa den forste ledige plassen;
  public void settInn(T element) {
    if (tabellPeker >= tabell.length) {
      tabell = utvidTabell();
    }
    tabell[tabellPeker] = element;
    tabellPeker++;
    storrelsen++;
    }

  //kopierer den gamle tabellen til en ny og storre tabell
  private T[] utvidTabell () {
    T[] nyTabell = (T[]) new Object[tabell.length*2];
    for (int i = 0; i < tabell.length ; i++ ) {
      nyTabell[i] = tabell[i];
    }
    return nyTabell;
  }

}
