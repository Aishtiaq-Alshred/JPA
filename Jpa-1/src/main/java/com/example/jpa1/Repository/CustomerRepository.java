package com.example.jpa1.Repository;

import com.example.jpa1.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {

    Customer findCustomerById(Integer id);
}
