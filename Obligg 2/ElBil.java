public class ElBil extends Vehicle {
  private double effekt;

  public ElBil(String reg, double effekten) {
    regnmr = reg;
    effekt = effekten;
  }
  public void info(){
    System.out.println("\nType motorvogn: ElBil");
    System.out.println("Regnmr: " +  regnmr);
    System.out.println("batteritid: " + effekt + " kWh");

  }
}
