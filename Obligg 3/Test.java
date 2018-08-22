public class Test {
  public static void main(String[] args)  {
      StatiskTabell<Integer> tabell = new StatiskTabell<Integer>(4);
      System.out.println(tabell.storrelse());
      tabell.settInn(2);
      tabell.settInn(32);
      tabell.settInn(1);

      System.out.println(tabell.hentFraPlass(1));
      System.out.println(tabell.erTom());
      //tabell.settInn(1);
      //tabell.settInn(1);

      for (Integer s: tabell) {
        System.out.println(s);
      }
      System.out.println("\nDynamsik Test");
      DynamiskTabell<Integer> dytabell = new DynamiskTabell<Integer>(10);
      dytabell.settInn(20);
      System.out.println(dytabell.hentFraPlass(0));

      for (int i = 0; i < 30; i++) {
        dytabell.settInn(i);
      }
      System.out.println(dytabell.erTom());
      System.out.println(dytabell.hentFraPlass(2));

      for (Integer i : dytabell ) {
        System.out.println(i);
      }

      OrdnetLenkeliste<String> liste = new OrdnetLenkeliste<String>();
      liste.settInn("z");
      liste.settInn("b");
      liste.settInn("11");
      liste.settInn("c");
      liste.settInn("a");
      liste.settInn("11");
      liste.fjern();

      for (String i : liste ) {
        System.out.println(i);
      }

  }
}
