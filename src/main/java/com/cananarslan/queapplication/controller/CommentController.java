package com.cananarslan.queapplication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cananarslan.queapplication.services.CommentServices;

@RestController
@RequestMapping("/comments")
public class CommentController {
	private CommentServices commentServices;
	
	public CommentController(CommentServices commentServices) {
		this.commentServices = commentServices;
	}
	
}
