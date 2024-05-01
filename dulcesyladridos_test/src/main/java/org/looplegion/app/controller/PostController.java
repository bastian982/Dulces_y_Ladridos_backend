package org.looplegion.app.controller;

import java.util.List;

import org.looplegion.app.entity.Post;
import org.looplegion.app.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("api/v1/posts")
public class PostController {

	PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping
	ResponseEntity<List<Post>> getAllPost(
			@RequestParam(name="active",
										required =false,
										defaultValue = "true") boolean active
					){
		return new ResponseEntity<List<Post>>( postService.getAllPosts(), HttpStatus.OK);
	}
	
	@PostMapping
	ResponseEntity<Post> createPost(@RequestBody Post post ){
		Post createdPost = postService.createPost(post);
		
		return new ResponseEntity<Post>( createdPost, HttpStatus.CREATED );		
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deletePost(@PathVariable("id") Long id ){
		postService.deletePost(id);
		return new ResponseEntity<String>("Post id " + id + " successfully deleted", HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	ResponseEntity<Post> updatePost(
			@RequestBody Post post, 
			@PathVariable("id") Long id  
			){
		Post updatedPost = postService.updatePost(post, id);
		
		return new ResponseEntity<Post>( updatedPost, HttpStatus.OK );		
	}
	
}




















