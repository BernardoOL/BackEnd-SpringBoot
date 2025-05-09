package com.springProject.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springProject.course.entities.Category;
import com.springProject.course.entities.Order;
import com.springProject.course.entities.Product;
import com.springProject.course.entities.User;
import com.springProject.course.entities.enums.OrderStatus;
import com.springProject.course.repository.CategoryRepository;
import com.springProject.course.repository.OrderRepository;
import com.springProject.course.repository.ProductRepository;
import com.springProject.course.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", null);
        User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", null);

        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        Category cat1 = new Category(null, "Electronics", null);
        Category cat2 = new Category(null, "Books",null);
        Category cat3 = new Category(null, "Computers",null);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "", null);
        Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "", null);
        Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "", null);
        Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "", null);
        Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "", null); 

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
        
    }

}
