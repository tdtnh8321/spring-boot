package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	// Kiểm tra tên đăng nhập đã tồn tại hay chưa
	@Query(value = "SELECT count(*) from customers where Username=?1", nativeQuery = true)
	int checkUsername(String username);

	// Kiểm tra đăng nhập
	@Query(value = "SELECT count(*) from customers where Username=?1 and Password=?2", nativeQuery = true)
	int checkLogin(String username, String password);

	// Lấy thông tin tài khoản theo username vs password
	@Query(value = "SELECT * from customers where Username=?1 and Password=?2", nativeQuery = true)
	CustomerEntity getAccount(String username, String password);
	
	//Lấy thông tin tài khoản theo customerID
	@Query(value = "SELECT * from customers where CustomerID=?1", nativeQuery = true)
	CustomerEntity getAccountByCustomerID(Long id);
}
