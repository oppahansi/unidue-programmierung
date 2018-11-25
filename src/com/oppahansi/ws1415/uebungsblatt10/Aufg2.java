/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt10;

public class Aufg2 {

  public static void main(String args[]) {
    Graph gr = new Graph();
    //Graph: 8 Knoten
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

    a.fuegeEin(new Kante(b, "1"));
    a.fuegeEin(new Kante(g, "5"));
    b.fuegeEin(new Kante(c, "7"));
    c.fuegeEin(new Kante(a, "6"));
    c.fuegeEin(new Kante(f, "2"));
    d.fuegeEin(new Kante(e, "2"));
    d.fuegeEin(new Kante(h, "12"));
    e.fuegeEin(new Kante(a, "9"));
    e.fuegeEin(new Kante(h, "13"));
    f.fuegeEin(new Kante(e, "3"));
    f.fuegeEin(new Kante(d, "5"));
    g.fuegeEin(new Kante(c, "3"));

    gr.gibAus();
    System.out.println(gr.gleicheKanten());
    System.out.println(gr.sucheWeg(f, b));
    System.out.println(gr.istZyklenfrei());
  }
}
