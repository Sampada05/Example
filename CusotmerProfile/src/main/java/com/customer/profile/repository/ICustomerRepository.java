package com.customer.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.profile.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
