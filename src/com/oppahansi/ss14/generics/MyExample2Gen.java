package com.oppahansi.ss14.generics;

import java.util.ArrayList;

public class MyExample2Gen {

  private static ArrayList<String> names = new ArrayList<String>();
  private static String[] ordner;

  public static void main(String[] args) {
    names.add("Anton");
    names.add("Boris");
    names.add("Caesar");
    //		names.add(2);

    ordner = new String[names.size()];

    for (int i = 0; i < names.size(); ++i) {
      ordner[i] = names.get(i);
    }

    for (int i = 0; i < ordner.length; i++) {
      System.out.println(ordner[i]);
    }
  }
}
/*
 * - Castings vermieden durch generics
 * - Zugriff auf die gleiche Klasse java.util.ArrayList
 * - <String> -> generic -> parametrisieren -> muss einen Datentyp enthalten
 * - nun enth�lt java.util.ArrayList ausschliesslich String
 * - fehlerhaftes Casting w�rde schon Compilierzeit gefunden werden
 * - unm�glich versehentlich anderen Datentyp hinzuf�gen
 * - generic -> Hilfswerkzeug -> sicherer code
 */
