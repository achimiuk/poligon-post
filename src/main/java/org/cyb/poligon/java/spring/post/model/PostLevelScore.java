package org.cyb.poligon.java.spring.post.model;

import java.util.Optional;
import java.util.stream.Stream;

public class PostLevelScore {

  private IncrementalNamedCounter juniorScore;
  private IncrementalNamedCounter midScore;
  private IncrementalNamedCounter seniorScore;

  public PostLevelScore() {
    juniorScore = new IncrementalNamedCounter("JUNIOR", 0);
    midScore = new IncrementalNamedCounter("MID", 0);
    seniorScore = new IncrementalNamedCounter("SENIOR", 0);
  }

  public PostLevelScore(long juniorInitScore, long midInitScore, long seniorInitScore) {
    juniorScore = new IncrementalNamedCounter("JUNIOR", juniorInitScore);
    midScore = new IncrementalNamedCounter("MID", midInitScore);
    seniorScore = new IncrementalNamedCounter("SENIOR", seniorInitScore);
  }

  public String getLevel() {
//    final Optional<IncrementalNamedCounter> maxOpt = Stream.of(juniorScore, midScore, seniorScore)
    final Optional<IncrementalNamedCounter> maxOpt = Stream.of(seniorScore, midScore, juniorScore)
        .max(IncrementalNamedCounter::compareTo);

    return maxOpt.get().getName();
  }

  public void doScore(String level) {
    Optional<IncrementalNamedCounter> selectedCounterOpt = Stream.of(juniorScore, midScore, seniorScore)
        .filter(counter -> counter.getName().equals(level))
        .findAny();
    selectedCounterOpt.ifPresent(IncrementalNamedCounter::increment);
  }

  public Long getJuniorScore() {
    return juniorScore.getValue();
  }
  public Long getMidScore() {
    return midScore.getValue();
  }
  public Long getSeniorScore() {
    return seniorScore.getValue();
  }

  public void setJuniorScore(Long juniorScore) {
    this.juniorScore = new IncrementalNamedCounter("JUNIOR", juniorScore);
  }

  public void setMidScore(Long midScore) {
    this.midScore = new IncrementalNamedCounter("MID", midScore);
  }

  public void setSeniorScore(Long seniorScore) {
    this.seniorScore = new IncrementalNamedCounter("SENIOR", seniorScore);
  }
}
