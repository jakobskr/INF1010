//First in first out liste
public class Koe<T> extends LenkeListe<T> {

  //Setter ett element bakerst i listen
  public void settInn(T element) {

    //setter at det forste elementet havner i midten
    if (erTom()) {
      Node temp = new Node(element);
      temp.settNeste(bak);
      bak.settForrige(temp);
      foran.settNeste(temp);
      temp.settForrige(foran);
      temp = null;
      storrelsen++;
    }

    //her setter den inn elementet bakerst i listen
    else {
      Node temp = new Node(element);
      temp.settForrige(bak.hentForrige());
      bak.hentForrige().settNeste(temp);
      bak.settForrige(temp);
      temp.settNeste(bak);
      temp = null;
      storrelsen++;
    }
  }

}
