package org.cyb.poligon.java.spring.post.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("POST_ENTITY")
@Getter @Setter
@NoArgsConstructor
public class PostEntity {

  @Id
  private Long id;
  private String title;
  private PostLevelScoreEntity postLevelScoreEntity;

}
