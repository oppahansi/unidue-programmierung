package com.oppahansi.ss14.miniprojekt6;

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
