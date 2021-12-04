package com.kenneth.springbootecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenneth.springbootecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
