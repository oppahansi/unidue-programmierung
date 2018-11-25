/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp6;

/* Veranstaltung mit Name und Turnus (Sommer-/Wintersemester) */
public class Course {

  private String name;
  private Term term;

  public Course(String name, Term term) {
    this.name = name;
    this.term = term;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Term getTerm() {
    return term;
  }

  public void setTerm(Term term) {
    this.term = term;
  }

  @Override
  public String toString() {
    return String.format("'%s' (%s)", name, term);
  }
}
