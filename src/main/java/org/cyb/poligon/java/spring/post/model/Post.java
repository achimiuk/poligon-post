package org.cyb.poligon.java.spring.post.model;

import lombok.NoArgsConstructor;

public class Post {
  Long id;
  String title;
  //URL url;
  PostLevelScore level;
  //PostType type;
  //Set<PostTechnology> technologies;


  public Post() {
  }

  public Post(Long id, String title, Long juniorScore, Long midScore, Long seniorScore) {
    this.id = id;
    this.title = title;
    this.level = new PostLevelScore(juniorScore, midScore, seniorScore);
  }

  public Post(Long id, String title) {
    this(id, title, 0L, 0L, 0L);
  }

  public Post(String postTitle) {
    this.title = postTitle;
    this.level = new PostLevelScore(0,0,0);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public PostLevelScore getLevel() {
    return level;
  }

  public void setLevels( Long juniorScore, Long midScore, Long seniorScore) {
    this.level = new PostLevelScore(juniorScore, midScore, seniorScore);
  }

  public void setLevel(PostLevelScore postLevelScore) {
    this.level = postLevelScore;
  }
}
