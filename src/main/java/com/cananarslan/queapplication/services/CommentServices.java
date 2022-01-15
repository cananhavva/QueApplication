package com.cananarslan.queapplication.services;

import org.springframework.stereotype.Service;

import com.cananarslan.queapplication.repository.CommentRepository;

@Service
public class CommentServices {
	
	private CommentRepository commentRepository;
	
	public CommentServices(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
}
