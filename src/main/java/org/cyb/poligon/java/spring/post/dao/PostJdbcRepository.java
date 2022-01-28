package org.cyb.poligon.java.spring.post.dao;

import org.cyb.poligon.java.spring.post.dao.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostJdbcRepository extends CrudRepository<PostEntity,Long> {

}
