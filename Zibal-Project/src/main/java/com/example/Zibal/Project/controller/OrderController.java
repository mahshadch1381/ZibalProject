package com.example.Zibal.Project.controller;


import com.example.Zibal.Project.model.Orders;
import com.example.Zibal.Project.enums.PaymentStatus;
import com.example.Zibal.Project.repository.OrderRepository;
import com.example.Zibal.Project.service.Order.AddOrderService;
import com.example.Zibal.Project.service.Order.DeleteOrderService;
import com.example.Zibal.Project.service.Order.UpdateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path="/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    AddOrderService addOrderService;
    @Autowired
    UpdateOrderService updateOrderService;
    @Autowired
    DeleteOrderService deleteOrderService;

    @PostMapping(path="/addOrder")
    public @ResponseBody String addNewUser (@RequestParam Long amount) {

        return addOrderService.addOrder(amount);
    }

    @GetMapping(path="/getAllOrders")
    public @ResponseBody Iterable<Orders> getAllUsers() {

        return orderRepository.findAll();
    }

    @PutMapping(path="/updateOrder")
    public ResponseEntity<?> updateUser(@RequestParam int id, @RequestParam Long amount, @RequestParam Date date,@RequestParam PaymentStatus paymentStatus) {
       return updateOrderService.updateOrderInfo(id,amount,date,paymentStatus);
    }
    @DeleteMapping(path="/deleteOrder")
    public ResponseEntity<?> deleteUser(@RequestParam int id) {
        return deleteOrderService.deleteOrder(id);
    }
}
