import java.util.Iterator;
@SuppressWarnings("unchecked")
public class OrdnetLenkeliste<T extends Comparable<T> >  extends LenkeListe<T>{

  @Override
  //setter inn elementer basert paa storrelsen dens, minst forst og storst bakerst
  public void settInn(T element) {

    //sorger at det forste elementet havner i midten
    if (erTom()) {
      Node temp = new Node(element);
      temp.settNeste(bak);
      bak.settForrige(temp);
      foran.settNeste(temp);
      temp.settForrige(foran);
      temp = null;
      storrelsen++;
    }

    //setter inn elementer basert paa storrelse
    else {
      Node denne = foran;
      boolean innsatt = false;
      Node temp = new Node(element);

      /*sjekker om elementet er mindre enn noe i listen
      vis det er mindre enn noe saa blir det plassert foran det elementet*/
      while(!(denne.hentNeste() == bak)) {
          if(temp.hentInnhold().compareTo(denne.hentNeste().hentInnhold()) <= 0) {
          //System.out.println(temp.hentInnhold().compareTo(denne.hentNeste().hentInnhold()));
          temp.settNeste(denne.hentNeste());
          denne.hentNeste().settForrige(temp);
          denne.settNeste(temp);
          temp.settForrige(denne);
          temp = null;
          storrelsen++;
          innsatt = true;
          break;
        }
        denne = denne.hentNeste();
      }

      //vis elementet var storre enn alt annet i listet saa havner det bakerst
      if (innsatt == false) {
        temp.settForrige(bak.hentForrige());
        bak.hentForrige().settNeste(temp);
        bak.settForrige(temp);
        temp.settNeste(bak);
        temp = null;
        storrelsen++;
      }
    }
  }

}
