public class PersonBil extends FossilBil {
  private int antallPlasser;
  PersonBil(String reg, double utslipp, int plasser) {
    regnmr = reg;
    co2Utslipp = utslipp;
    antallPlasser = plasser;
  }

  public void info(){
    System.out.println("\nType motorvogn: PersonBil");
    System.out.println("Regnmr: " +  regnmr );
    System.out.println("Utslipp: " + co2Utslipp + " g/km");
    System.out.println("Seter: " + antallPlasser);
  }
}
