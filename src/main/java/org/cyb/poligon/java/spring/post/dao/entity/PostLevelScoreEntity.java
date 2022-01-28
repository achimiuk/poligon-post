package org.cyb.poligon.java.spring.post.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table("POST_LEVEL_SCORE")
@Getter @Setter
@NoArgsConstructor
public class PostLevelScoreEntity {

  @Transient
  private PostEntity postEntity;

  private Long juniorScore;
  private Long midScore;
  private Long seniorScore;

}
