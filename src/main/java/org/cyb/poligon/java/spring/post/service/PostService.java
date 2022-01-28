package org.cyb.poligon.java.spring.post.service;

import java.util.Optional;
import org.cyb.poligon.java.spring.post.dao.PostJdbcRepository;
import org.cyb.poligon.java.spring.post.dao.entity.PostEntity;
import org.cyb.poligon.java.spring.post.mapper.PostMapper;
import org.cyb.poligon.java.spring.post.model.Post;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private final PostJdbcRepository postJdbcRepository;
  private final PostMapper postMapper;

  @Autowired
  public PostService(PostJdbcRepository postJdbcRepository) {
    this.postJdbcRepository = postJdbcRepository;
    this.postMapper = Mappers.getMapper(PostMapper.class);
  }

  public Post save(Post post) {
    final PostEntity postEntity = postMapper.modelToEntity(post);
    final PostEntity savedPostEntity = postJdbcRepository.save(postEntity);
    return postMapper.entityToModel(savedPostEntity);
  }

  public Optional<Post> findById(Long postId) {
    final Optional<PostEntity> postEntityOptional = this.postJdbcRepository.findById(postId);
    return postEntityOptional.map(postMapper::entityToModel);
  }

}
