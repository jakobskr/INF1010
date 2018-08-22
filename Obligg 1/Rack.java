import java.util.ArrayList;
public class Rack {
  private int noderPerRack = 0;
  private ArrayList<Node> nodeListe = new ArrayList<Node>();
  public Rack(int noderPerRack) {
    this.noderPerRack = noderPerRack;
  }

  public boolean sjekkOmFull() {
    return nodeListe.size() < noderPerRack;
  }

  public void settInnNode(Node node) {
    nodeListe.add(node);
  }
}
