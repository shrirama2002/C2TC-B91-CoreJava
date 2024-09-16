package com.tnsif.springboot.smmsorder.service;

import com.tnsif.springboot.smmsorder.entities.Order;

import java.util.List;

public interface OrderService {
    public List<Order> listAll();
    public Order get(Long id);
    public void save(Order order);
    public void deleteById(Long id);
    public Order updateProduct(Long id, Order order);
}
