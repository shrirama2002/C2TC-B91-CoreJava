package com.tnsif.springboot.smmsorder.service.impl;

import com.tnsif.springboot.smmsorder.entities.Order;
import com.tnsif.springboot.smmsorder.repository.OrderRepository;
import com.tnsif.springboot.smmsorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> listAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order get(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(()  -> new NoSuchElementException("Cannot find the order"));
        return order;
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(()  -> new NoSuchElementException("Cannot find the order"));
        orderRepository.deleteById(order.getId());
//        orderRepository.deleteById(id);
    }

    @Override
    public Order updateProduct(Long id, Order order) {
        Order savedOrder = orderRepository.findById(id).orElseThrow(()  -> new NoSuchElementException("Cannot find the order"));

        savedOrder.setTotal(order.getTotal());
        savedOrder.setCustomerId(order.getCustomerId());
        savedOrder.setPaymentMode(order.getPaymentMode());
        savedOrder.setShopId(order.getShopId());

        return orderRepository.save(savedOrder);
    }


}
