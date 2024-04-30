package org.looplegion.app.repository;

import java.util.Optional;
import org.looplegion.app.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long>{
	
	//encontrar por Rating
	Optional<Review> findByRating(Integer Rating);
	// SELECT * FROM Review WHERE validation = 1;
	Iterable<Review> findAllByValidationTrue();
	// SELECT * FROM Review WHERE validation = 0;
	Iterable<Review> findAllByValidationFalse();
	// SELECT * FROM Review WHERE active = ?1;

}

