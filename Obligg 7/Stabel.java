//first in last out lenkeliste
public class Stabel<T> extends LenkeListe<T> {

  public boolean contains(T sjekker) {
    for (T sample : this) {
      if (sample == sjekker) {
        return true;
      }
    }
    return false;
  }
  public String toString() {
    String print="";
    for (T sample : this) {
      print = print + " --> " + sample;
    }
    return print;
  }

  public Stabel<T> kopierLenkeListe() {
    Stabel<T> nyStabel = new Stabel<T>();
    for (T sample: this) {
      nyStabel.settInn(sample);
    }
    return nyStabel;
  }

}
