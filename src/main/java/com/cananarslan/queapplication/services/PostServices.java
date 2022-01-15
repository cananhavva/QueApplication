package com.cananarslan.queapplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cananarslan.queapplication.entity.Post;
import com.cananarslan.queapplication.entity.User;
import com.cananarslan.queapplication.repository.PostRepository;
import com.cananarslan.queapplication.requests.PostCreateRequest;
import com.cananarslan.queapplication.requests.PostUpdateRequest;

@Service
public class PostServices {
	private PostRepository postRepository;
	private UserServices userServices;
	
	public PostServices(PostRepository postRepository) {
		
		this.postRepository = postRepository;
	}
	
	public PostServices(UserServices userServices) {
		
		this.userServices = userServices;
	}
	
	public List<Post> getAllPosts(Optional<Long> userId) {
		if (userId.isPresent())
			return postRepository.findByUserId(userId.get());
		
		return postRepository.findAll();
	}
	
	public Post getOnePostById(Long postId) {
		
		return postRepository.findById(postId).orElse(null);
	}
	
	public Post createOnePost(PostCreateRequest newPostRequest) {
		User user = userServices.getOneUser(newPostRequest.getUserId());
		if (user == null)
			return null;
		Post toSave = new Post();
		toSave.setId(newPostRequest.getId());
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user);
		
		return postRepository.save(toSave);
	}
	
	public Post updateOnePost(Long postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if (post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
			
		}
		return null;
	}
	
	public void deletePostById(Long postId) {
		postRepository.deleteById(postId);
		
	}
	
}
