package com.cananarslan.queapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cananarslan.queapplication.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByUserId(Long userId);
	
}
