/*
 * Created by: Diaoliu https://github.com/Diaoliu/Rekursive-Datenstrukturen
 *
 * <p>For learning purpose only.
 *
 * <p>Modified by oppahansi (refactored the code) No code changes has been made.
 */
package com.oppahansi.ws1415.klausuraufgaben.baum;

import java.util.LinkedList;

public class Baum {

  Knoten Wurzel; // Wurzel des Binärbaums.

  public static void main(String[] args) {
    Baum baum = new Baum();
    //        String[] bezeicher = {"A","B","C","D","E", "F","G","H"};
    //        for (String s : bezeicher) baum.erzeuge_Blatt(s);
    //        int [] zahl = {5,3,10,6,2,1,8,12,4};

    int[] zahl = {5, -8, 8, 2, 6, -9, 3, -2, -5};
    for (int i : zahl) {
      baum.erzeuge_Blatt(i);
    }
    baum.durchLauf(baum.Wurzel);
    //        int[] sortietZahlen = baum.neu(16);
    //        for (int i : zahl) baum.sortiereein(sortietZahlen, i);
    //        for (int i : sortietZahlen) System.out.print(i + ", ");
    //        baum.sortiereein(sortietZahlen, 7);
    //        System.out.println(" ");
    //        for (int i : sortietZahlen) System.out.print(i + ", ");
    //        System.out.println(" ");
    //        baum.durchLauf(baum.Suchbaumwurzel(sortietZahlen));
    //        for (int i : zahl) baum.erzeuge_Blatt(i);
    //        baum.durchLauf(baum.Wurzel);
    //        baum.loeschenBlatt();
    //        baum.durchLauf(baum.Wurzel);
    //        System.out.println(baum.h(baum.Wurzel));
    //        System.out.println(baum.e(baum.Wurzel));
    //        int[] zahlen = baum.z();
    //        for (int i : zahlen)  System.out.print(i + ", ");
    //        System.out.println(baum.biggerThanKind());
    //        baum.v();
    //        baum.durchLauf(baum.Wurzel);
    //        System.out.println(baum.b());
  }

  void erzeuge_Blatt(int Zahl) {
    Wurzel = erzeuge_Blatt(Zahl, Wurzel, 0);
  }

  private Knoten erzeuge_Blatt(int z, Knoten k, int tief) {
    if (k == null) {
      return new Knoten(z, tief);
    } else if (z <= k.Zahl) {
      k.links = erzeuge_Blatt(z, k.links, tief + 1);
      return k;
    } else {
      k.rechts = erzeuge_Blatt(z, k.rechts, tief + 1);
      return k;
    }
  }

  void erzeuge_Blatt(String bez) { //用链表队列实现二叉堆的广度优先添加节点（非排序添加）
    if (this.Wurzel == null) {
      Wurzel = new Knoten(bez);
    } else {
      LinkedList<Knoten> list = new LinkedList<Knoten>();
      list.add(Wurzel);
      erzeuge_Blatt(bez, list);
    }
  }

  // Aufgabe 3.2: Vervollständigung von Bäumen

  private void erzeuge_Blatt(String bez, LinkedList<Knoten> l) {
    while (l.size() != 0) {
      Knoten k = l.pollFirst();
      if (k.links == null) {
        k.links = new Knoten(bez);
        break;
      } else if (k.rechts == null) {
        k.rechts = new Knoten(bez);
        break;
      } else {
        l.addLast(k.links);
        l.addLast(k.rechts);
      }
    }
  }

  int h(Knoten k) { // Höhe des Binärbaums.
    if (k == null) {
      return 0;
    } else {
      return 1 + Math.max(h(k.links), h(k.rechts));
    }
  }

  int e(Knoten k) { // Anz. Knoten mit genau 1 Nachfolger.
    if (k != null) {
      if (k.links == null && k.rechts != null || k.links != null && k.rechts == null) {
        System.out.println(k.Zahl);
        return 1 + e(k.links) + e(k.rechts);
      } else {
        return 0 + e(k.links) + e(k.rechts);
      }
    }

    return 0;
  }

  void v() { // Vervollständigung des Binärbaums mit 1.
    int i = h(Wurzel);
    v(i, Wurzel);
  }

  // Aufgabe 3.3: Inhalte von Blättern in Array übernehmen

  void v(int tief, Knoten k) { // Vervollständigung des Binärbaums mit 1.
    if (tief <= 1) {
      return;
    }
    if (k.links == null) {
      k.links = new Knoten(1);
    }
    if (k.rechts == null) {
      k.rechts = new Knoten(1);
    }
    v(tief - 1, k.links);
    v(tief - 1, k.rechts);
  }

  int b() { // Anzahl der Blätter
    return b(this.Wurzel);
  }

  int b(Knoten k) { // Anzahl der Blätter
    if (k == null) {
      return 0;
    } else if (k.links == null && k.rechts == null) {
      return 1;
    } else {
      return b(k.links) + b(k.rechts);
    }
  }

  void durchLauf(Knoten k) { // 中序遍历所有节点 In Order
    if (k != null) {
      durchLauf(k.links);
      if (k.Zahl != 0) {
        System.out.print(k.Zahl + " " + "(" + k.Tiefe + ")");
      }
      if (k.Bez != null) {
        System.out.print(k.Bez + " --> ");
      } else {
        System.out.print(" --> ");
      }
      durchLauf(k.rechts);
    }
  }

  int[] z() { // Array, das Zahlen der Blätter enthält
    // 将二叉堆的底层节点转移到一维数组中
    if (this.Wurzel != null) {
      int[] zahlen = new int[this.b()];
      z(Wurzel, zahlen);
      return zahlen;
    }
    return null;
  }

  void z(Knoten k, int[] zahlen) {
    if (k != null) {
      z(k.links, zahlen);
      if (k.links == null && k.rechts == null) {
        for (int i = 0; i < zahlen.length; i++) {
          if (zahlen[i] == 0) {
            zahlen[i] = k.Zahl;
            break;
          }
        }
        System.out.println(k.Zahl);
      }
      z(k.rechts, zahlen);
    }
  }

  //Aufgabe 3.4 Blätter entfernen

  boolean p(int x) {
    int[] zahlen = z();
    if (zahlen != null) {
      for (int i : zahlen) {
        if (x == i) {
          return true;
        }
      }
    }
    return false;
  }

  boolean biggerThanKind() { //测试是否所有父节点的数值大于子节点的数值
    return this.Wurzel == null || biggerThanKind(Wurzel.links) && biggerThanKind(Wurzel.rechts);
  }

  boolean biggerThanKind(Knoten k) { //
    if (k == null) {
      return true;
    } else {
      if (k.links != null && k.rechts != null) {
        return k.Zahl > k.links.Zahl
            && k.Zahl > k.rechts.Zahl
            && biggerThanKind(k.links)
            && biggerThanKind(k.rechts);
      } else if (k.links == null && k.rechts != null) {
        return k.Zahl > k.rechts.Zahl && biggerThanKind(k.rechts);
      } else {
        return k.links == null || k.Zahl > k.links.Zahl && biggerThanKind(k.links);
      }
    }
  }

  void loeschenBlatt() { // entfernen alle Blätter des Baums
    loeschenBlatt(Wurzel);
  }

  //Aufgabe 3.5 Array und Suchbaum 数组和堆

  void loeschenBlatt(Knoten k) {
    if (k != null) {
      if (k.links != null) {
        if (k.links.links == null && k.links.rechts == null) {
          k.links = null;
        } else {
          loeschenBlatt(k.links);
        }
      }
      if (k.rechts != null) {
        if (k.rechts.links == null && k.rechts.rechts == null) {
          k.rechts = null;
        } else {
          loeschenBlatt(k.rechts);
        }
      }
    }
  }

  int[] neu(int anZahl) {
    int[] zahlen = new int[anZahl + 1];
    zahlen[0] = 0;
    return zahlen;
  }

  boolean sortiert(int[] a) {
    for (int i = 1; i < a[0]; i++) {
      if (a[i] > a[i + 1]) {
        return false;
      }
    }
    return true;
  }

  int[] sortiereein(int[] a, int e) {
    a[0]++;
    int temp = e;
    for (int i = 1; i < a[0]; i++) {
      int zahl = a[i];
      if (temp <= a[i]) {
        a[i] = temp;
        temp = zahl;
      }
    }
    a[a[0]] = temp;
    return a;
  }

  int suche(int[] a, int e) {
    for (int i = 1; i <= a[0]; i++) {
      if (e < a[i]) {
        return 0;
      } else if (e == a[i]) {
        return a[i];
      }
    }
    return 0;
  }

  Knoten Suchbaumwurzel(int[] a) { // 一维数组转换成二叉堆，并返回根
    Baum baum = new Baum();
    Suchbaumwurzel(baum, a, 1, a[0]);
    return baum.Wurzel;
  }

  //Aufgabe 3.6 Teilbäume

  void Suchbaumwurzel(Baum b, int[] a, int left, int right) {
    if ((right - left) >= 0) {
      int mitte = (right - left) / 2 + left;
      b.erzeuge_Blatt(a[mitte]);
      Suchbaumwurzel(b, a, left, mitte - 1);
      Suchbaumwurzel(b, a, mitte + 1, right);
    }
  }

  boolean TB(Knoten k1, Knoten k2) { //判断节点k1 是否在k2的子树上
    String bez = k1.Bez;
    return TB(k2.links, bez) || TB(k2.rechts, bez);
  }

  boolean TB(Knoten k, String bez) {
    return k != null && ((k.Bez.equals(bez)) || TB(k.links, bez) || TB(k.rechts, bez));
  }

  // Aufgabe 3.7: Teilweise sortierter Baum

  boolean gleich(Knoten k) { //判断节点K的子树是否结构和内容都相同
    return k.links == null && k.rechts == null
        || k.links != null
            && k.rechts != null
            && k.links.Bez.equals(k.rechts.Bez)
            && gleich(k.links)
            && gleich(k.rechts);
  }

  Knoten frei() {
    return frei(Wurzel);
  }

  Knoten frei(Knoten k) {
    if (k == null) {
      return null;
    } else if (!(k.links != null && k.rechts != null)) {
      return k;
    } else {
      Knoten kLeft = frei(k.links);
      Knoten kRight = frei(k.rechts);
      if (kLeft.Tiefe == kRight.Tiefe) {
        return kLeft;
      } else {
        return kLeft.Tiefe < kRight.Tiefe ? kLeft : kRight;
      }
    }
  }

  //Aufgabe 3.8 Blaetter im Baum
  boolean zwei() {
    return zwei(Wurzel);
  }

  //Aufgabe 3.9 Baum und Rekursion

  boolean zwei(Knoten k) {
    return k != null && (k.links == null && k.rechts == null || zwei(k.links) && zwei(k.rechts));
  }

  Knoten maxizahl() {
    Knoten k = maxizahl(Wurzel);
    if (k == null) {
      return Wurzel;
    }
    if (k.Zahl > Wurzel.Zahl) {
      return k;
    } else {
      return Wurzel;
    }
  }

  //Aufgabe 3.10 Bäume

  Knoten maxizahl(Knoten k) {
    if (k == null) {
      return null;
    } else {
      Knoten k1 = maxizahl(k.links);
      Knoten k2 = maxizahl(k.rechts);
      Knoten max;
      if (k1 == null && k2 == null) {
        return k;
      } else if (k1 != null && k2 != null) {
        max = k1.Zahl > k2.Zahl ? k1 : k2;
      } else {
        max = k2 == null ? k1 : k2;
      }
      return max.Zahl > k.Zahl ? max : k;
    }
  }

  int minBlattabstand() {
    return minBlattabstand(Wurzel);
  }

  int minBlattabstand(Knoten k) {
    if (k == null) {
      return 0;
    } else {
      return 1 + Math.min(minBlattabstand(k.links), minBlattabstand(k.rechts));
    }
  }

  int Blattanzahl() {
    return Blattanzahl(Wurzel);
  }

  // Test Area 测试部分

  int Blattanzahl(Knoten k) {
    if (k == null) {
      return 0;
    } else if (k.links == null && k.rechts == null) {
      return 1;
    } else {
      return Blattanzahl(k.links) + Blattanzahl(k.rechts);
    }
  }
}

class Knoten { // Ein Knoten des Binärbaums.

  int Zahl, // In den Knoten eingetragene Zahl.
      Tiefe; // Tiefgrad dieser Knote
  String Bez;
  Knoten links, rechts; // Nachfolger im Binärbaum.

  Knoten(int Zahl) {
    this.Zahl = Zahl;
    links = rechts = null;
  }

  Knoten(int Zahl, int Tiefe) {
    this.Zahl = Zahl;
    this.Tiefe = Tiefe;
    links = rechts = null;
  }

  Knoten(String Bez) {
    this.Bez = Bez;
    links = rechts = null;
  }
}
