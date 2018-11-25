/*
 * Created by: Diaoliu https://github.com/Diaoliu/Rekursive-Datenstrukturen
 *
 * <p>For learning purpose only.
 *
 * <p>Modified by oppahansi (refactored the code) No code changes has been made.
 */
package com.oppahansi.ws1415.klausuraufgaben.list;

import java.util.Random;

public class Aufgaben {

  public static void main(String[] args) {
    Aufgaben aufgaben = new Aufgaben();
    char[] a = {'z', 'q', 'a', 'b'};
    char[] b = {'q', 'a', 'b', 'z'};
    int[] zahlen = {1, 2, 3, 4, 6, 7, 3};
    System.out.println(aufgaben.a(a, 'z'));
    System.out.println(aufgaben.b(zahlen));
    System.out.println(aufgaben.c(a, b, 3));
  }

  //Aufgabe 1.2
  int Fkt(int x) {
    System.out.println(x);
    if (x < 9) {
      return x;
    }
    if (Fkt(x / 2) % 2 == 0) {
      return Fkt(x - 10);
    } else {
      return Fkt(x - 20);
    }
  }

  //Aufgabe 2.3
  boolean a(char[] p, char z) {
    for (char i : p) {
      if (i != z) {
        return false;
      }
    }
    return true;
  }

  boolean b(int[] s) {
    for (int i = 0; i < s.length - 1; i += 2) {
      if (s[i] >= s[i + 1]) {
        return false;
      }
    }
    return true;
  }

  boolean c(char[] p, char[] q, int n) {
    int sum = 0;
    for (int i = 0; i <= p.length - n; i++) {
      for (int j = 0; j <= q.length - n; j++) {
        for (int k = 0; k < n; k++) {
          if (p[i + k] != q[j + k]) {
            break;
          } else {
            sum++;
          }
          if (sum == n) {
            return true;
          }
        }
      }
    }
    return sum == n;
  }

  //Aufgaben 2.4
  boolean g(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] == a[i + 1]) {
        return true;
      }
    }
    return false;
  }

  boolean m(int[] a) {
    int durchschnitt = 0, sum = 0;
    for (int i : a) {
      sum += i;
    }
    durchschnitt = sum / a.length;
    for (int i : a) {
      if (i == durchschnitt) {
        return true;
      }
    }
    return false;
  }
}

//Aufgaben 2.5
class LKW {

  int eintraege;
  int[] Lastzug, Rad;
  Random random = new Random();

  LKW(int eintraege) {
    this.eintraege = eintraege;
    Lastzug = new int[eintraege];
    Rad = new int[eintraege];
    for (int i = 0; i < eintraege; i++) {
      Lastzug[i] = 1 + random.nextInt(53);
      Rad[i] = 1 + random.nextInt(24);
    }
  }

  public static void main(String[] args) {
    LKW lkw = new LKW(121);
    int[][] schaden = lkw.schaden();
    for (int[] i : schaden) {
      for (int j : i) {
        System.out.print(j + "  ");
      }
      System.out.println("-------");
    }
  }

  int[][] schaden() {
    int[][] schaden = new int[53][24];
    for (int i = 0; i < eintraege; i++) {
      schaden[Lastzug[i] - 1][Rad[i] - 1]++;
    }
    return schaden;
  }
}

// Aufgabe 2.7  Liste für eine Zugfahrt

class Fahrt {

  Bahnhof Start, Ziel;

  public static void main(String[] args) {
    Fahrt essenNachHamm = new Fahrt();
    essenNachHamm.EssenHamm();
    Bahnhof bahnhof = essenNachHamm.Start;
    essenNachHamm.print(bahnhof);
    essenNachHamm.verspaetet(3);
    System.out.println("--");
    essenNachHamm.print(bahnhof);
  }

  void EssenHamm() {
    this.Start = this.Ziel = new Bahnhof("Essen", 0, 4);
    new Bahnhof(this, 16, "Bochum", 2);
    new Bahnhof(this, 18, "Dortmund", 4);
    new Bahnhof(this, 30, "Hamm", 3);
  }

  boolean verspaetet(int Zusatzdauer) {
    Bahnhof bahnhof = this.Start;
    int Gesamtfahrzeit = Ziel.Ankunft;

    while (bahnhof != null) {
      bahnhof.Dauer += Zusatzdauer;
      bahnhof = (bahnhof.nS != null) ? bahnhof.nS.nB : null;
    }

    return (Ziel.Ankunft - Gesamtfahrzeit) * 100 / Gesamtfahrzeit > 10;
  }

  boolean zielnah(Bahnhof b) {
    Bahnhof start = Start;
    Bahnhof bahnhof = b;
    int entfernungS = 0, entfernungN = 0;
    if (b == Start && b == null) {
      return false;
    } else if (b == Ziel) {
      return true;
    } else {
      while (start != b) {
        entfernungS += start.nS.Entfernung;
        start = start.nS.nB;
      }
      while (bahnhof.nS != null) {
        entfernungN += bahnhof.nS.Entfernung;
        bahnhof = bahnhof.nS.nB;
      }

      return entfernungN < entfernungS;
    }
  }

  private void print(Bahnhof bahnhof) {
    while (true) { //输出列车经过的车站与之间的距离
      System.out.print(bahnhof.Name + bahnhof.Dauer);
      if (bahnhof.nS != null) {
        System.out.print(" --> " + bahnhof.nS.Entfernung + " --> ");
      }
      if (bahnhof.nS == null) {
        break;
      }
      bahnhof = bahnhof.nS.nB;
    }
  }
}

class Bahnhof {

  String Name; // Name des Bahnhofs.
  Strecke nS; // Strecke, die als nächste befahren wird.
  int Ankunft; // Zeitpunkt der Ankunft im Bahnhof (in Minuten).
  int Dauer; // Dauer des Halts im Bahnhof (in Minuten).
  int Abfahrt; // Zeitpunkt der Abfahrt (in Minuten).

  Bahnhof(String Name, int Ankunft, int Dauer) {
    this.Name = Name;
    this.Ankunft = Ankunft;
    this.Dauer = Dauer;
    this.Abfahrt = Ankunft + Dauer;
    this.nS = null;
  }

  Bahnhof(Fahrt f, int Entfernung, String Name, int Dauer) {
    this(Name, f.Ziel.Abfahrt + Entfernung / 2, Dauer);
    f.Ziel.nS = new Strecke(this, Entfernung);
    f.Ziel = this;
  }
}

class Strecke {

  Bahnhof nB; // nächster Bahnhof, zu dem der Zug hinfährt.
  int Entfernung; // Länge der Strecke (in Kilometern).

  Strecke(Bahnhof nB, int Entfernung) {
    this.nB = nB;
    this.Entfernung = Entfernung;
  }
}

//Aufgabe 2.8

class ProdukteList {

  Produkt Kopf, Fuss; // Anfang und Ende der Liste der Produkte.

  public static void main(String[] args) {
    ProdukteList angebot = new ProdukteList();
    angebot.Angebot();
    angebot.Gesamtpreis();
    Produkt p = angebot.Kopf;
    while (p != null) {
      System.out.println(p.Bez + " --- ePreis: " + p.ePreis + ", " + "gPreis: " + p.gPreis);
      p = p.Nf;
    }
    System.out.println(angebot.zweitteuerstesProdukt());
  }

  void Zubehoer(String a, String b) {
    Produkt p = null, z = null;
    Produkt s = Kopf;
    while (s != null) {
      if (s.Bez.equals(a)) {
        p = s;
      }
      if (s.Bez.equals(b)) {
        z = s;
      }
      s = s.Nf;
    }
    if (p != null && z != null) {
      p.Zubehoer = z;
    }
  }

  void Gesamtpreis() {
    Produkt produkt = Kopf;
    while (produkt != null) {
      Produkt zubehoer = produkt.Zubehoer;
      float zubehoerPreis = 0;
      while (zubehoer != null) {
        zubehoerPreis += zubehoer.ePreis * 0.9;
        zubehoer = zubehoer.Zubehoer;
      }
      produkt.gPreis = produkt.ePreis + zubehoerPreis;
      produkt = produkt.Nf;
    }
  }

  void Angebot() {
    new Produkt("Lampe", 5.00f, this);
    new Produkt("Bleistift", 0.29f, this);
    new Produkt("Batterie", 2.00f, this);
    new Produkt("Computer", 400.00f, this);
    new Produkt("Funkmaus", 28.00f, this);
    Zubehoer("Lampe", "Batterie");
    Zubehoer("Computer", "Funkmaus");
    Zubehoer("Funkmaus", "Batterie");
  }

  float zweitteuerstesProdukt() {
    float zweit = 0.0f, erst = 0.0f;
    Produkt p = Kopf;
    while (p != null) {
      if (p.ePreis >= erst) {
        zweit = erst;
        erst = p.ePreis;
      } else if (p.ePreis >= zweit) {
        zweit = p.ePreis;
      }
      p = p.Nf;
    }

    return zweit;
  }
}

class Produkt {

  Produkt Nf; // Verweis auf das Nachfolger-Produkt in der Liste.
  String Bez; // Bezeichnung eines Produkts.
  float ePreis; // Einzelpreis eines Produkts in Euro.
  float gPreis; // Gesamtpreis eines Produkts in Euro.
  Produkt Zubehoer; // Verweis auf ein benötigtes Zubehör-Produkt.

  Produkt(String Bez, float ePreis, ProdukteList Liste) { //构造函数
    this.Nf = null;
    this.Bez = Bez;
    this.ePreis = ePreis;
    this.gPreis = 0.0f;
    this.Zubehoer = null;

    if (Liste.Kopf == null) { //Produkt zum End der Produktliste einzufuegen.
      Liste.Kopf = Liste.Fuss = this;
    } else {
      Liste.Fuss = Liste.Fuss.Nf = this;
    }
  }
}
