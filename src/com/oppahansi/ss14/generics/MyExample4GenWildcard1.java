package com.oppahansi.ss14.generics;

import java.util.ArrayList;

public class MyExample4GenWildcard1 {

  private static ArrayList<String> names = new ArrayList<String>();
  private static ArrayList<Integer> ages = new ArrayList<Integer>();

  public static void main(String[] args) {
    print();
  }

  private static int length(ArrayList<?> list) {
    return list.size();
  }

  //	private static <T> int length(ArrayList<T> list)
  //	{
  //		return list.size();
  //	}

  public static void print() {
    names.add("Anton");
    names.add("Boris");
    names.add("Caesar");

    ages.add(25);
    ages.add(32);
    ages.add(41);

    System.out.println(Integer.toString(length(names)) + " Datentyp: " + names.get(0).getClass());
    System.out.println(Integer.toString(length(ages)) + " Datentyp: " + ages.get(0).getClass());
  }
}
/*
 * - Wildcards -> ?
 * - die Methode length kann nun ArrayList von unterschiedlichen Datentypen annehmen
 */
