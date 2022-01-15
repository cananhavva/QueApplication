package com.cananarslan.queapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cananarslan.queapplication.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
