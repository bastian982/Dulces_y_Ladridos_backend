package org.looplegion.app.service;

import java.util.List;

import org.looplegion.app.entity.Post;
import org.looplegion.app.entity.PostCategory;


public interface PostService {
	Post getPostById(Long id);
	Post getPostByTitle(String title);
	Post createUser(Post post);
	List<Post> getAllPostsByCategory(PostCategory postCategory);

	Post updatePost(Post post, Long id);
	void deletePost(Long id);

}