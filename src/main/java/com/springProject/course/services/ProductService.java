package com.springProject.course.services;

import com.springProject.course.dto.ProductDTO;
import com.springProject.course.entities.Product;
import com.springProject.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO findById(long id) {
        Product product = productRepository.findById(id).get();
        return new ProductDTO(product);
    }

}
