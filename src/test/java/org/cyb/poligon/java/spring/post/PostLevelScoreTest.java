package org.cyb.poligon.java.spring.post;

import org.cyb.poligon.java.spring.post.model.PostLevelScore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostLevelScoreTest {

  @Test
  void should_return_SENIOR_as_max_scored_level() {
    // given level scores 0,0,0
    final PostLevelScore postLevelScore = new PostLevelScore(0, 0, 0);

    // when JUNIOR level is scored more times than others (3,2,1)
    postLevelScore.doScore("JUNIOR");
    postLevelScore.doScore("JUNIOR");
    postLevelScore.doScore("JUNIOR");
    postLevelScore.doScore("MID");
    postLevelScore.doScore("MID");
    postLevelScore.doScore("SENIOR");



    // then max scored level shoud be SENIOR
    Assertions.assertEquals("JUNIOR", postLevelScore.getLevel());

  }

  @Test
  void should_return_SENIOR_when_all_levels_are_equal_scored() {
    // given level scores 0,0,0
    final PostLevelScore postLevelScore = new PostLevelScore(0, 0, 0);

    // when all level are equal scored
    postLevelScore.doScore("SENIOR");
    postLevelScore.doScore("JUNIOR");
    postLevelScore.doScore("MID");

    // then max level shoud be returned
    Assertions.assertEquals("SENIOR", postLevelScore.getLevel());

  }

  @Test
  void should_return_higher_level_when_two_levels_are_max_scored() {
    // given level scores 0,0,0
    final PostLevelScore postLevelScore1 = new PostLevelScore(0, 0, 0);
    final PostLevelScore postLevelScore2 = new PostLevelScore(0, 0, 0);
    final PostLevelScore postLevelScore3 = new PostLevelScore(0, 0, 0);

    // when
    // 1st case: MID and JUINOR level are max scored
    postLevelScore1.doScore("JUNIOR");
    postLevelScore1.doScore("MID");
    // 2nd case: SENIOR and JUNIOR are max scored
    postLevelScore2.doScore("JUNIOR");
    postLevelScore2.doScore("SENIOR");
    // 3rd case: SENIOR and MID are max scored
    postLevelScore3.doScore("MID");
    postLevelScore3.doScore("SENIOR");


    // then higher level (MID) shoud be returned
    Assertions.assertEquals("MID", postLevelScore1.getLevel());
    Assertions.assertEquals("SENIOR", postLevelScore2.getLevel());
    Assertions.assertEquals("SENIOR", postLevelScore3.getLevel());

  }

}
