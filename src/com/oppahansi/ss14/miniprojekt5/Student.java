package com.oppahansi.ss14.miniprojekt5;

public class Student extends Person {

  private String course;
  private int libraryPassword;

  public Student(String firstName, String lastName, int yearOfBirth) {
    super(firstName, lastName, yearOfBirth);
    this.libraryPassword = yearOfBirth;
  }

  public int getLibraryPassword() {
    return libraryPassword;
  }

  public void enroll(String course) {
    this.course = course;
  }

  public void enroll() {
    this.course = "Germanistik";
  }

  public String getCourse() {
    return course;
  }
}
