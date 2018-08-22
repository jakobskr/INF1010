public class LasteBil extends FossilBil {
  private double nyttevekt;
  LasteBil(String reg, double utslipp, double last) {
    regnmr = reg;
    co2Utslipp = utslipp;
    nyttevekt = last;
  }
  public void info(){
    System.out.println("\nType motorvogn: LasteBil");
    System.out.println("Regnmr: " +  regnmr );
    System.out.println("Utslipp: " + co2Utslipp+ " g/km");
    System.out.println("Nyttevekt: " + nyttevekt + " kg");
  }
}
