package com.example.jpa1.Service;

import com.example.jpa1.Api.ApiException;
import com.example.jpa1.Model.Customer;
import com.example.jpa1.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServise {
    private final CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }


    public void updateCustomer(Integer id,Customer customer){
        Customer customer1=customerRepository.findCustomerById(id);

        if(customer==null){
            throw new ApiException("customer not found");
        }

        customer1.setName(customer.getName());

        customerRepository.save(customer1);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }


}
