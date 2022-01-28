package org.cyb.poligon.java.spring.post.model;


public class IncrementalNamedCounter implements Comparable<IncrementalNamedCounter> {
  private Long value = 0L;
  private String name;

  public IncrementalNamedCounter(String counterName, long l) {
    name = counterName;
    value = l;
  }

  void increment() {
    value += 1;
  }

  Long getValue() {
    return value;
  }

  @Override
  public int compareTo(IncrementalNamedCounter o) {
    final int comparedByValue = value.compareTo(o.getValue());
    return comparedByValue;
/*
    if (comparedByValue == 0) {
      return name.compareTo(o.getName());
    } else {
      return comparedByValue;
    }
*/
  }

  public String getName() {
    return this.name;
  }
}
