package com.demo.project103.controller;

import java.util.List;

import com.demo.project103.domain.Customer;
import com.demo.project103.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    final CustomerService customerService;

    @GetMapping
    public List<Customer> getAll(@RequestHeader("X-TenantID") String tenantId) {
        return customerService.findAll();
    }

    @PostMapping
    public Customer saveCustomer(@RequestHeader("X-TenantID") String tenantId, @RequestBody Customer customer) {
        return customerService.save(customer);
    }
}
