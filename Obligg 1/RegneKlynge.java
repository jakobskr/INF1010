import java.util.ArrayList;
public class RegneKlynge {
  int noderPerRack = 0;
  //Rack currentRack = null;
  ArrayList<Rack> rackListe = new ArrayList<Rack>();

  public RegneKlynge(int noderPerRack) {
    this.noderPerRack = noderPerRack;
    rackListe.add(new Rack(noderPerRack));
  }

  public void settInnNode(Node node) {
    if (!nyesteRack().sjekkOmFull()) {
      rackListe.add(new Rack(noderPerRack));
    }
    nyesteRack().settInnNode(node);
  }

  public void flops() {
    System.out.println("her");
  }

  public Rack nyesteRack() {
    return rackListe.get(rackListe.size() -1);
  }

}
