package org.looplegion.app.service;

import java.util.List;

import org.looplegion.app.entity.Post;
import org.looplegion.app.entity.PostCategory;


public interface PostService {
	Post getPostById(Long id);
	Post getPostByTitle(String title);
	Post createPost(Post post);
	//List<Post> getAllPostsByCategory(PostCategory postCategory);
	List<Post> getAllPosts(boolean isActive);
	
	Post updatePost(Post post, Long id);
	void deletePost(Long id);
	List<Post> getAllPostsByCategory(PostCategory postCategory);
	

}