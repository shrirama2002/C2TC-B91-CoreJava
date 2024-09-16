package com.tnsif.springboot.smmsorder.controllers;

import com.tnsif.springboot.smmsorder.entities.Order;
import com.tnsif.springboot.smmsorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping
    ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.listAll();
        return ResponseEntity.ok(orders);
    }


    @GetMapping("/{id}")
    ResponseEntity<Order> getSingleOrder(@PathVariable Long id) {
        Order order = orderService.get(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderService.save(order);
        return ResponseEntity.ok("Created");
    }


    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteOrderById(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("/{id}")
    ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order updatedOrder = orderService.updateProduct(id, order);
        return ResponseEntity.ok(updatedOrder);
    }
}
