package com.example.jpa1.Controller;

import com.example.jpa1.Model.Customer;
import com.example.jpa1.Service.CustomerServise;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServise customerService;

    @GetMapping("/get")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.status(200).body(customerService.getAllCustomers());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody @Valid Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer added successfully.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Integer id, @RequestBody @Valid Customer customer) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body("Customer updated successfully.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer deleted successfully.");
    }





}
