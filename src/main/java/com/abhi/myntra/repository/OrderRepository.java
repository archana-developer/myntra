package com.abhi.myntra.repository;

import com.abhi.myntra.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
