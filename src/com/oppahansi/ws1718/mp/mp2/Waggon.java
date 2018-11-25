/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 */
package com.oppahansi.ws1718.mp.mp2;

public class Waggon {

    private Waggon next;

    private int capacity;
    private int passengers;
    private final String name;

    public Waggon(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Waggon getNext() {
        return next;
    }

    public void setNext(Waggon next) {
        this.next = next;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
