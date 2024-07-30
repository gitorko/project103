package com.demo.project103.service;

import java.util.List;

import com.demo.project103.domain.Customer;
import com.demo.project103.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
