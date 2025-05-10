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
        User user1 = User.builder()
            .id(null)
            .name("Maria Brown")
            .email("maria@gmail.com")
            .phone("988888888")
            .password("123456")
            .build();

        User user2 = User.builder()
            .id(null)
            .name("Alex Green")
            .email("alex@gmail.com")
            .phone("977777777")
            .password("123456")
            .build();

        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        Category category1 = new Category(null, "Electronics", null);
        Category category2 = new Category(null, "Books",null);
        Category category3 = new Category(null, "Computers",null);

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        Product product1 = Product.builder()
                .id(null)
                .name("The Lord of the Rings")
                .description("Lorem ipsum dolor sit amet, consectetur.")
                .price(90.5)
                .imgUrl("")
                .build();

        Product product2 = Product.builder()
                .id(null)
                .name("Smart TV")
                .description("Nulla eu imperdiet purus. Maecenas ante.")
                .price(2190.0)
                .imgUrl("")
                .build();
                
        Product product3 = Product.builder()
                .id(null)
                .name("Macbook Pro")
                .description("Nam eleifend maximus tortor, at mollis.")
                .price(1250.0)
                .imgUrl("")
                .build();

        Product product4 = Product.builder()
                .id(null)
                .name("PC Gamer")
                .description("Donec aliquet odio ac rhoncus cursus.")
                .price(1200.0)
                .imgUrl("")
                .build();
                
        Product product5 = Product.builder()
                .id(null)
                .name("Rails for Dummies")
                .description("Cras fringilla convallis sem vel faucibus.")
                .price(100.99)
                .imgUrl("")
                .build(); 

        product1.getCategories().add(category2);
        product2.getCategories().add(category1);
        product2.getCategories().add(category3);
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product5.getCategories().add(category2);
        

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
        
    }

}
