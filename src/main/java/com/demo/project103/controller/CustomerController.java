package com.demo.project103.controller;

import java.util.List;

import com.demo.project103.domain.Customer;
import com.demo.project103.domain.Search;
import com.demo.project103.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    final CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.findAll();
    }

    @PostMapping("/search")
    public List<Customer> search(@RequestBody Search search) {
        return customerService.search(search);
    }

    @PostMapping("/rank-search")
    public List<Customer> rankSearch(@RequestBody Search search) {
        return customerService.rankSearch(search);
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
}
