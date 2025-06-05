package com.springProject.course.services;

import com.springProject.course.dto.ProductDTO;
import com.springProject.course.entities.Product;
import com.springProject.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO findById(long id) {
        Product product = productRepository.findById(id).get();
        return new ProductDTO(product);
    }

    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(product -> new ProductDTO(product));
    }

}
