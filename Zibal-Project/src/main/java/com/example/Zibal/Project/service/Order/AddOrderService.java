package com.example.Zibal.Project.service.Order;


import com.example.Zibal.Project.model.Orders;
import com.example.Zibal.Project.enums.PaymentStatus;
import com.example.Zibal.Project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddOrderService {
    @Autowired
    private OrderRepository orderRepository;
    public String addOrder(Long amount){
        Orders order=new Orders();
        order.setStatus(PaymentStatus.NOT_PAYED);
        order.setAmount(amount);
        orderRepository.save(order);
        return "Saved";
    }
}
