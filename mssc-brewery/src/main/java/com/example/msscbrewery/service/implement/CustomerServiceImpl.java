package com.example.msscbrewery.service.implement;

import com.example.msscbrewery.model.CustomerDTO;
import com.example.msscbrewery.service.interfaces.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getById(UUID id) {
        return CustomerDTO
                .builder()
                .id(UUID.randomUUID())
                .name("Quang Duong")
                .build();
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        log.debug("Updating ..... ");
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting.......");
    }
}
