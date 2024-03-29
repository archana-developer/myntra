package com.abhi.myntra.service;

import com.abhi.myntra.dto.CustomerDTO;
import com.abhi.myntra.entity.Customer;

import java.util.List;

public interface CustomerService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> findAllCustomers();
    CustomerDTO findCustomerById(Long id);
    void deleteCustomer(Long id);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
}
