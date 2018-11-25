/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp5;

public class Doctor extends Person {

  private String phdTopic;

  public Doctor(String firstName, String lastName, int yearOfBirth) {
    super(firstName, lastName, yearOfBirth);
    this.phdTopic = "Dr.";
  }

  public String getPhdTopic() {
    return phdTopic;
  }

  public void setPhdTopic(String phdTopic) {
    this.phdTopic = phdTopic;
  }

  public String getName() {
    return phdTopic + " " + super.getName();
  }
}
