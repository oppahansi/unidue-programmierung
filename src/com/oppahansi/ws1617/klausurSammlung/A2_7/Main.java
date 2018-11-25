/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_7;

public class Main {

  public static void main(String[] args) {

    Fahrt f = new Fahrt();
    f.EssenHamm();
    Bahnhof b = f.start.nS.nB;

    System.out.println(
        f.start.ankunft
            + " "
            + f.start.nS.nB.ankunft
            + " "
            + f.start.nS.nB.nS.nB.ankunft
            + " "
            + f.start.nS.nB.nS.nB.nS.nB.abfahrt);

    System.out.println(f.zielnah(b));
  }
}
