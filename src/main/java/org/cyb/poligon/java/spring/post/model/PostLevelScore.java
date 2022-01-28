package org.cyb.poligon.java.spring.post.model;

import java.util.Optional;
import java.util.stream.Stream;

public class PostLevelScore {

  IncrementalNamedCounter juniorScore;
  IncrementalNamedCounter midScore;
  IncrementalNamedCounter seniorScore;

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

  private boolean allScoresEqual() {
    return juniorScore.getValue().equals(midScore.getValue())
        && midScore.getValue().equals(seniorScore.getValue());
  }

  public void doScore(String level) {
    Optional<IncrementalNamedCounter> selectedCounterOpt = Stream.of(juniorScore, midScore, seniorScore)
        .filter(counter -> counter.getName().equals(level))
        .findAny();
    selectedCounterOpt.ifPresent(IncrementalNamedCounter::increment);
  }

}
