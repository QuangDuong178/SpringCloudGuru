package com.example.msscbrewery.service.interfaces;

import com.example.msscbrewery.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getById(UUID id);

    CustomerDTO saveNewCustomer(CustomerDTO customerDTO);

    void updateCustomer(UUID customerId, CustomerDTO customerDTO);

    void deleteById(UUID customerId);
}
