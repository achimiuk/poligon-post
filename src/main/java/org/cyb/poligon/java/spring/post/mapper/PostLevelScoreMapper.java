package org.cyb.poligon.java.spring.post.mapper;

import org.cyb.poligon.java.spring.post.dao.entity.PostLevelScoreEntity;
import org.cyb.poligon.java.spring.post.model.PostLevelScore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PostLevelScoreMapper {

  @Mapping(source = "juniorScore", target = "juniorScore")
  @Mapping(source = "midScore", target = "midScore")
  @Mapping(source = "seniorScore", target = "seniorScore")
  PostLevelScore entityToModel(PostLevelScoreEntity postLevelScoreEntity);

  @Mapping(target = "juniorScore", source = "juniorScore")
  @Mapping(target = "midScore", source = "midScore")
  @Mapping(target = "seniorScore", source = "seniorScore")
  PostLevelScoreEntity modelToEntity(PostLevelScore postLevelScore);
}
