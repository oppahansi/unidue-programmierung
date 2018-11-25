package com.oppahansi.ss14.generics;

import java.util.ArrayList;

public class MyExample3GenInterfaces1 {

  private static ArrayList<String> names = new ArrayList<String>();
  private static String[] ordner;

  public static void main(String[] args) {
    names.add("Anton");
    names.add("Boris");
    names.add("Caesar");
    // names.add(2);

    ordner = new String[names.size()];
    int i = 0;
    for (String s :
        names) //f�ngt bei 0 an und geht alle string names durch und gibt die als s zur�ck
    {
      ordner[i] = s;
      i++;
    }

    for (int k = 0; k < ordner.length; k++) {
      System.out.println(ordner[k]);
    }
  }
}
/*
 * - generics nicht nur auf Klassen bezogen
 * - auch Interfaces
 * - in diesem Beispiel java.lang.Iterable
 * - ist auch in java.util.ArrayList
 * - besondere Variante der for-Schleife (Java 5)
 * - for-Schleife iteriert
 * - wichti ist -> Iterator auch parametisiert (Iterator<T>)
 * - Beispiel f�r Klasse java.util.ArrayList

package java.util;

import java.lang.*;

public class ArrayList<T> implements Iterable<T>
{
  public Iterator<T> iterator()
  {
  }

  public boolean add(T t)
  {
  }

  public T get(int index)
  {
  }
}

 * - Platzhalter -> T -> Datentyp -> Parameter
 * - T kann an mehreren Stellen auftauchen
 * - Generische Klassen sind demnach unvollst�ndiger Code
 *
 */
