package com.springProject.course.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springProject.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
