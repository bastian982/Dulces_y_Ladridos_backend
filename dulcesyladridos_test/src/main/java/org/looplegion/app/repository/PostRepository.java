package org.looplegion.app.repository;

import org.looplegion.app.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
	

}
