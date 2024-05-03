package org.looplegion.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.looplegion.app.entity.Post;
import org.looplegion.app.entity.PostCategory;
import org.looplegion.app.repository.PostRepository;
import org.looplegion.app.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

	PostRepository postRepository;
	
	//Constructor
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@Override
	public List<Post> getAllPostsByCategory(PostCategory postCategory) {
	    Iterable<Post> posts = postRepository.getAllByPostcategory(postCategory);
	    List<Post> postList = new ArrayList<>();
	    posts.forEach(postList::add);
	    return postList;
	}
	@Override
	public Post getPostById(Long id) {
		Optional<Post> postOptional = postRepository.findById(id);
		Post existingPost;
		
		if(postOptional.isPresent()) {
			existingPost = postOptional.get();
			return existingPost;
		}else {
			throw new IllegalStateException("Post does not exist with id " + id);
		}
	}

	@Override
	public Post getPostByTitle(String title) {
	    Optional<Post> postOptional = postRepository.findByTitle(title);
	    Post existingPost;

	    if (postOptional.isPresent()) {
	        existingPost = postOptional.get();
	        return existingPost;
	    } else {
	        throw new IllegalStateException("Post does not exist with title " + title);
	    }
	}

	@Override
	public Post createPost(Post post) {
		post.setId(null);
		
		if(postRepository.existsByTitle(post.getTitle())) {
			throw new IllegalStateException("Post already exists with that title" +post.getTitle());
		}
		
		return postRepository.save(post);
	}

	/*@Override
	public List<Post> getAllPostsByCategory(PostCategory postCategory) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public Post updatePost(Post post, Long id) {
		Post existingPost = getPostById(id);
		existingPost.setTitle(post.getTitle());
		existingPost.setDescription(post.getDescription());
		existingPost.setContent(post.getContent());
		existingPost.setPostcategory(post.getPostcategory());
		return postRepository.save(existingPost);
		
	}

	@Override
	public void deletePost(Long id) {
		Post existingPost = getPostById(id);
		postRepository.delete(existingPost);
		
	}

	@Override
	public List<Post> getAllPosts(boolean isActive) {
		try {
			List<Post> publicaciones = (List<Post>) postRepository.findAll();
			return publicaciones.isEmpty() ? null : publicaciones;
		}catch(Exception e)
		{
			throw new IllegalStateException("Error while retrieving list of products");
		}
	}

}
