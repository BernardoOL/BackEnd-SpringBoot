package com.springProject.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springProject.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
