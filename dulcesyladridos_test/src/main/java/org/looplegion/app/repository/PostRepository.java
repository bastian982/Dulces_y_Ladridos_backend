package org.looplegion.app.repository;

import java.util.Optional;

import org.looplegion.app.entity.Post;
import org.springframework.data.repository.CrudRepository;



public interface PostRepository extends CrudRepository<Post, Long> {
	
	//Encontrar un post por titulo
	Optional<Post> findByTitle(String title);
	

    // Verificar si un post existe por título
    boolean existsByTitle(String title);
}
