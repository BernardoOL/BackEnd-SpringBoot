package com.springProject.course.resources;

import org.springframework.web.bind.annotation.RestController;

import com.springProject.course.entities.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Maria", "maria@gmail.com", "99999999", "123456");
        return ResponseEntity.ok().body(user);
    }

}
