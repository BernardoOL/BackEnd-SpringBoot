package com.springProject.course.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springProject.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
