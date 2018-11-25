package com.oppahansi.ss14.extra;

public class Trailer {

  private final String name;
  private Trailer next;
  private int capacity;
  private int gifts;

  public Trailer(String name, int capacity) {
    this.name = name;
    this.capacity = capacity;
  }

  public Trailer(String name, int capacity, int gifts) {
    this(name, capacity);

    this.gifts = gifts;
  }

  public Trailer getNext() {
    return next;
  }

  public void setNext(Trailer next) {
    this.next = next;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getGifts() {
    return gifts;
  }

  public void setGifts(int gifts) {
    this.gifts = gifts;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    String information = String.format("%s [%d / %d Geschenke]", name, gifts, capacity);

    if (next != null) {
      information += " <--> " + next.toString();
    }

    return information;
  }
}
