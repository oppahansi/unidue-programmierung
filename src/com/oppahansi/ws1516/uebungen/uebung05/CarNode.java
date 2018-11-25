/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung05;
/*
 * Diese Klasse realisiert die einzelnen Listenelemente fuer eine CarList. Da
 * die Liste doppelt verkettet sein soll, hat jedes Element einen Verweis auf
 * einen Vorgaenger (previous) und einen Nachfolger (next). Desweiteren hat
 * jedes Listenelement einen Verweise auf ein Objekt Car (car).
 */

public class CarNode {

  public CarNode next;
  public CarNode previous;
  public Car car;

  public CarNode() {
    this.car = null;
    this.previous = null;
    this.next = null;
  }

  public CarNode(Car car, CarNode previous, CarNode next) {
    this.car = car;
    this.previous = previous;
    this.next = next;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public CarNode getPrevious() {
    return previous;
  }

  public void setPrevious(CarNode previous) {
    this.previous = previous;
  }

  public CarNode getNext() {
    return next;
  }

  public void setNext(CarNode next) {
    this.next = next;
  }
}
