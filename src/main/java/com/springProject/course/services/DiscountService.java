package com.springProject.course.services;

import com.springProject.course.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public double discount(Order order) {
        var valor = order.getBasic();
        var discount = order.getDiscount();

        return valor * (discount / 100);
    }


}
