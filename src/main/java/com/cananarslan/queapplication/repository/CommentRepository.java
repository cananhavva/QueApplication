package com.cananarslan.queapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cananarslan.queapplication.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
}
