package com.tnsif.springboot.smmsorder.repository;

import com.tnsif.springboot.smmsorder.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
