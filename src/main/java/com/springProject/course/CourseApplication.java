package com.springProject.course;

import com.springProject.course.entities.Order;
import com.springProject.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication implements CommandLineRunner {

	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Order order = new Order(1034, 150.0, 20.0);
		Order order2 = new Order(2282, 800.0, 10.0);
		Order order3 = new Order(1309, 95.90, 0.0);

		System.out.println("Pedido código: " + order.getCode());
		System.out.println("Valor Total: R$" + orderService.total(order) + "\n");
		// --
		System.out.println("Pedido código: " + order2.getCode());
		System.out.println("Valor Total: R$" + orderService.total(order2) + "\n");
		// --
		System.out.println("Pedido código: " + order3.getCode());
		System.out.println("Valor Total: R$" + orderService.total(order3));


	}
}
