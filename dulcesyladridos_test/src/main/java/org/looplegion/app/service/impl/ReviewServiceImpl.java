package org.looplegion.app.service.impl;

import java.util.List;

import org.looplegion.app.entity.Review;
import org.looplegion.app.service.ReviewService;

public class ReviewServiceImpl implements ReviewService{
	
	@Override
	public Review getReviewById(Long id) {
		return null;
	}
	@Override
	public Review getReviewByRating(Integer rating) {
		return null;
	}
	@Override
	public Review getReviewByValidation(boolean validation) {
		return null;
	}
	@Override
	public List<Review> getAllReviews(){
		return null;
	}
	@Override
	public List<Review> getAllReviewsByRating(Integer rating){
		return null;
	}
	@Override
	public List<Review> getAllReview(boolean isActive){
		return null;
	}
	@Override
	public void deleteReview(Long id){
	}
	

}
