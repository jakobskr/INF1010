import java.util.Iterator;
@SuppressWarnings("unchecked")

public class StatiskTabell<T> implements Tabell<T> {
  protected int tabellPeker = 0;
  protected T[] tabell;
  protected int storrelsen = 0;

  //konstruktoren som setter kapasiteten til arrayet.
  public StatiskTabell (int size) {
    tabell = (T[]) new Object[size];
  }

  @Override
  //returnerer hvor mange elementer som er i tabellen
  public int storrelse() {
    return storrelsen;
  }

  @Override
  //sjekker om tabellen er tom
  public boolean erTom() {
    return (storrelse() == 0);
  }

  @Override
  //setter inn et element paa den forste ledige plassen;
  public void settInn(T element) {
    if (tabellPeker >= tabell.length) {
      throw new FullTabellUnntak(tabell.length);
    }
    tabell[tabellPeker] = element;
    tabellPeker++;
    storrelsen++;
  }

  @Override
  //henter et element fra den oppgitte plassen
  public T hentFraPlass(int plass)  {
    if (plass < 0 || erTom() || plass >= tabell.length) {
      throw new UgyldigPlassUnntak(plass, storrelse());
    }
    return tabell[plass];
  }


    //lager en TabellIterator klasse
    private	class	TabellIterator implements	Iterator<T>	{
      private int peker = 0;
      private int kapasitet;

      //konstruktoren til Iteratoren
      private TabellIterator() {
        this.kapasitet = tabell.length;
      }

      @Override
      //sjekker om tabellen har en ny verdi
      public boolean hasNext()	{
        if (peker >= storrelse()) {
          return false;
        }
        else {
          return true;
        }
      }

      @Override
      public T next()	 {
        return tabell[peker++];
      }

      //bare lar den staa tom siden den ikke skal brukes
      public	void	remove() {
      }
    }

  public Iterator<T> iterator() {
    return new TabellIterator();
  }

}
