package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	@Query(value = "SELECT max(OrderID)+1 FROM orders", nativeQuery = true)
	Long createNewOrderID();
	@Query(value = "SELECT * FROM orders where OrderID=?1", nativeQuery = true)
	OrderEntity getOrderByIdOrderID(Long id);
}
