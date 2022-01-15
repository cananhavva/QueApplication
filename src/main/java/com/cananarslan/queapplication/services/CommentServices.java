package com.cananarslan.queapplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cananarslan.queapplication.entity.Comment;
import com.cananarslan.queapplication.entity.Post;
import com.cananarslan.queapplication.entity.User;
import com.cananarslan.queapplication.repository.CommentRepository;
import com.cananarslan.queapplication.requests.CommentCreateRequest;
import com.cananarslan.queapplication.requests.CommentUpdateRequest;

@Service
public class CommentServices {
	
	private CommentRepository commentRepository;
	private UserServices userServices;
	private PostServices postServices;
	
	public CommentServices(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public List<Comment> getAllComents(Optional<Long> userId, Optional<Long> postId) {
		if (userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		} else if (userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
		} else if (postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		} else
			
			return commentRepository.findAll();
	}
	
	public Comment getOneComment(Long commentId) {
		
		return commentRepository.findById(commentId).orElse(null);
	}
	
	public Comment createOneComment(CommentCreateRequest request) {
		User user = userServices.getOneUserId(request.getUserId());
		Post post = postServices.getOnePostById(request.getId());
		if (user != null && post != null) {
			Comment commentToSave = new Comment();
			commentToSave.setId(request.getId());
			commentToSave.setPost(post);
			commentToSave.setText(request.getText());
			commentToSave.setUser(user);
			return commentRepository.save(commentToSave);
		} else
			return null;
	}
	
	public Comment updateOneCommentById(Long commentId, CommentUpdateRequest commentUpdateRequest) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		if (comment.isPresent()) {
			Comment commentToUpdate = comment.get();
			commentToUpdate.setText(commentUpdateRequest.getText());
			return commentRepository.save(commentToUpdate);
			
		} else
			return null;
	}
	
	public void deleteOneCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
		
	}
}
