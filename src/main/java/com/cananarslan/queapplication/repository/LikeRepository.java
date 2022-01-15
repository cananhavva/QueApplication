package com.cananarslan.queapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cananarslan.queapplication.entity.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
	
}
