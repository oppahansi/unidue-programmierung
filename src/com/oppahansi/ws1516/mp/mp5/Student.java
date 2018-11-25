/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp5;

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
