package com.oppahansi.ss14.generics;

import java.util.Iterator;

public class MyExample3GenInterfaces2<T> implements Iterable<T> {

  public Iterator<T> iterator() {
    return null;
  }

  public boolean add(T t) {
    return false;
  }

  public T get(int index) {
    return null;
  }
}
