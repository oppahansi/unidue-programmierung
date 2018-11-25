package com.oppahansi.ss14.generics;

import java.util.ArrayList;

/*
 * - Java 5
 * - sogenannte parametrisierte Datentypen
 * - relativ sp�t
 * - nicht abwehrtskompatibel
 */

public class MyExample1 {

  private static ArrayList names = new ArrayList();
  private static String[] ordner;

  public static void main(String[] args) {
    names.add("Anton");
    names.add("Boris");
    names.add("Caesar");

    ordner = new String[names.size()];

    for (int i = 0; i < names.size(); ++i) {
      ordner[i] = (String) names.get(i);
    }

    //		for (int i = 0; i < ordner.length; i++)
    //		{
    //			System.out.println(ordner[i]);
    //		}
  }
}

/*
 * - java.util.ArrayList -> Container
 * - dynamisch
 * - intern Referenzen vom Datentyp Object
 * - Casting zu Laufzeit -> Laufzeitumgebung muss uns vertrauen
 * - Castings -> f�hrt schnell zu Programmierfehlern
 *
 * - Castings vermieden durch generics
 */
