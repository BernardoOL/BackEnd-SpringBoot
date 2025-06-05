package com.springProject.course.controllers;

import com.springProject.course.dto.ProductDTO;
import com.springProject.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findById(id);
    }

}
