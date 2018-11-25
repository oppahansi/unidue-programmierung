/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt10;

public class Aufg1 {

  public static void main(String args[]) {
    Graph gr = new Graph();
    Knoten a, b, c, d, e, f, g, h;

    a = new Knoten("A");
    b = new Knoten("B");
    c = new Knoten("C");
    d = new Knoten("D");
    e = new Knoten("E");
    f = new Knoten("F");
    g = new Knoten("G");
    h = new Knoten("H");

    gr.fuegeEin(a);
    gr.fuegeEin(b);
    gr.fuegeEin(c);
    gr.fuegeEin(d);
    gr.fuegeEin(e);
    gr.fuegeEin(f);
    gr.fuegeEin(g);
    gr.fuegeEin(h);

    a.fuegeEin(new Kante(b, "3"));
    b.fuegeEin(new Kante(c, "5"));
    b.fuegeEin(new Kante(f, "8"));
    c.fuegeEin(new Kante(d, "4"));
    c.fuegeEin(new Kante(a, "2"));
    d.fuegeEin(new Kante(b, "1"));
    e.fuegeEin(new Kante(c, "12"));
    e.fuegeEin(new Kante(f, "7"));
    f.fuegeEin(new Kante(g, "2"));

    gr.gibAus();
    System.out.println(gr.gleicheKanten());
    System.out.println(gr.sucheWeg(f, b));
    System.out.println(gr.istZyklenfrei());
  }
}
