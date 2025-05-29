package com.springProject.course.services;

import com.springProject.course.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;

    @Autowired
    DiscountService discountService;

    public double total(Order order) {
        var valor = order.getBasic();
        var discount = discountService.discount(order);
        var frete = shippingService.shipment(order);

        var total = (valor - discount) + frete;

        return total;
    }

}
