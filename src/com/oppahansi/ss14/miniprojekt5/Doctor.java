package com.oppahansi.ss14.miniprojekt5;

public class Doctor extends Person {

  private String phdTopic;

  public Doctor(String firstName, String lastName, int yearOfBirth) {
    super(firstName, lastName, yearOfBirth);
  }

  public String getPhdTopic() {
    return phdTopic;
  }

  public void setPhdTopic(String phdTopic) {
    this.phdTopic = phdTopic;
  }

  public String getName() {
    return "Dr. " + super.getName();
  }
}
