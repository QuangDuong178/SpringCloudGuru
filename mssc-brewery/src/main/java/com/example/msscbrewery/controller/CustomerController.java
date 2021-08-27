package com.example.msscbrewery.controller;

import com.example.msscbrewery.model.CustomerDTO;
import com.example.msscbrewery.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping(value = "/{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable("customerId")UUID customerId){
        return new ResponseEntity<>(customerService.getById(customerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDTO customerDTO){
        CustomerDTO savedCustomer = customerService.saveNewCustomer(customerDTO);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location","/api/v1/customer/"+ savedCustomer.getId().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }
    @PutMapping(value = "/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity handleUpdate(@PathVariable("customerId")UUID customerId,
                                       @RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerId, customerDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping(value = "/{customerId}")
    public void deleteById(@PathVariable("customerId") UUID customerId){
        customerService.deleteById(customerId);

    }
}
