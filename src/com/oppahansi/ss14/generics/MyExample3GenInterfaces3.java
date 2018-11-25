package com.oppahansi.ss14.generics;

import java.util.Collection;

public class MyExample3GenInterfaces3<T extends Collection> {

  T t;

  public MyExample3GenInterfaces3(T t) {
    this.t = t;
  }

  public int length() {
    return t.size();
  }
}

/*
 * - Platzhalter speziefizieren -> Einschr�nkungen hinzuf�gen
 * - MyExample3GenInterfaces3 muss eine Kindklasse von Collection sein
 * -
 */
