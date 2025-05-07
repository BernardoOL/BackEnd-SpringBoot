package com.springProject.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springProject.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
