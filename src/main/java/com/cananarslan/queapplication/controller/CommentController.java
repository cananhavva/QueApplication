package com.cananarslan.queapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cananarslan.queapplication.entity.Comment;
import com.cananarslan.queapplication.requests.CommentCreateRequest;
import com.cananarslan.queapplication.requests.CommentUpdateRequest;
import com.cananarslan.queapplication.services.CommentServices;

@RestController
@RequestMapping("/comments")
public class CommentController {
	private CommentServices commentServices;
	
	public CommentController(CommentServices commentServices) {
		this.commentServices = commentServices;
	}
	
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
		return commentServices.getAllComents(userId, postId);
		
	}
	
	@PostMapping
	public Comment createOneComment(@RequestBody CommentCreateRequest request) {
		return commentServices.createOneComment(request);
	}
	
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable Long commentId) {
		return commentServices.getOneComment(commentId);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateOneComment(@PathVariable Long commentId,
			@RequestBody CommentUpdateRequest commentUpdateRequest) {
		return commentServices.updateOneCommentById(commentId, commentUpdateRequest);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteOneCommentById(Long commentId) {
		commentServices.deleteOneCommentById(commentId);
	}
}
