package org.cyb.poligon.java.spring.post;

import org.cyb.poligon.java.spring.post.dao.entity.PostEntity;
import org.cyb.poligon.java.spring.post.mapper.PostMapper;
import org.cyb.poligon.java.spring.post.model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class PostMapperTest {

  @Test
  public void should_map_post_to_postEntity() {

    final Post post = new Post(1L, "Test");

    final PostMapper mapper = Mappers.getMapper(PostMapper.class);

    final PostEntity postEntity = mapper.modelToEntity(post);

    Assertions.assertEquals(post.getId(), postEntity.getId());
    Assertions.assertEquals(post.getTitle(), postEntity.getTitle());
    Assertions.assertEquals(post.getLevel().getJuniorScore(), postEntity.getPostLevelScoreEntity().getJuniorScore());
    Assertions.assertEquals(post.getLevel().getMidScore(), postEntity.getPostLevelScoreEntity().getMidScore());
    Assertions.assertEquals(post.getLevel().getSeniorScore(), postEntity.getPostLevelScoreEntity().getSeniorScore());
    Assertions.assertEquals(postEntity, postEntity.getPostLevelScoreEntity().getPostEntity());

  }

}
