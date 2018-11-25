/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp6;

import java.util.Comparator;

/* Vergleicht zwei Student-Objekte miteinander */
public class GradeComparator implements Comparator<Student> {

  @Override
  public int compare(Student s, Student t) {
    if (s.getAverageGrade() < t.getAverageGrade()) {
      return -1;
    } else if (s.getAverageGrade() == t.getAverageGrade()) {
      return 0;
    } else {
      return 1;
    }
  }
}
