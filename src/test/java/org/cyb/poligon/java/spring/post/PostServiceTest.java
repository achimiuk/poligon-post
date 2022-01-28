package org.cyb.poligon.java.spring.post;

import java.util.Optional;
import org.cyb.poligon.java.spring.post.model.Post;
import org.cyb.poligon.java.spring.post.service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

  @Autowired
  PostService postService;


  @Test
  public void should_save_sample_post() {

    // given
    final Post testPost = new Post("Test post");

    // when
    final Post savedPost = postService.save(testPost);


    // then
    Assertions.assertNotNull(savedPost.getId());
    Optional<Post> postOptional = postService.findById(savedPost.getId());
    Assertions.assertTrue(postOptional.isPresent());

  }

  @Test
  public void should_saved_post_got_senior_level_score() {

    // given
    final Post testPost = new Post("Test post");

    // when (zapisujemy post, odczytujemy, zwiekszamy ilosc glosow na poziom SENIOR, zapisujemy
    final Post savedPost = postService.save(testPost);
    Optional<Post> postOptional = postService.findById(savedPost.getId());
    final Post postToScore = postOptional.orElseThrow(AssertionError::new);
    postToScore.getLevel().doScore("SENIOR");
    postService.save(postToScore);

    // then
    Optional<Post> scoredPostOptional = postService.findById(savedPost.getId());
    final Post scoredPost = scoredPostOptional.orElseThrow(AssertionError::new);
    Assertions.assertEquals("SENIOR", scoredPost.getLevel().getLevel());

  }


}
