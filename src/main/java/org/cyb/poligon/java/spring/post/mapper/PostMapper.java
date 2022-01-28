package org.cyb.poligon.java.spring.post.mapper;

import org.cyb.poligon.java.spring.post.dao.entity.PostEntity;
import org.cyb.poligon.java.spring.post.model.Post;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = {PostLevelScoreMapper.class})
public interface PostMapper {

  @Mapping(source = "postLevelScoreEntity", target = "level")
  Post entityToModel(PostEntity postEntity);

  @Mapping(target = "postLevelScoreEntity", source = "level")
  PostEntity modelToEntity(Post post);

  @AfterMapping
  default void setParentRelation(@MappingTarget PostEntity target) {
    target.getPostLevelScoreEntity().setPostEntity(target);
  }

}
