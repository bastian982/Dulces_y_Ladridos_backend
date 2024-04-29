package org.looplegion.app.service;
import java.util.List;
import org.looplegion.app.entity.Review;



public interface ReviewService {
	

		Review getReviewById(Long id);
		Review getReviewByRating(Integer rating);
		Review getReviewByValidation(boolean validation);
		
		List<Review> getAllReviews();
		List<Review> getAllReviewsByRating(Integer rating);
		List<Review> getAllReview(boolean isActive);
		
		void deleteReview(Long id);
	}
