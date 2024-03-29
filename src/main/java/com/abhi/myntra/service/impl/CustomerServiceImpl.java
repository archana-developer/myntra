package com.abhi.myntra.service.impl;

import com.abhi.myntra.dto.AddressDTO;
import com.abhi.myntra.dto.CustomerDTO;
import com.abhi.myntra.dto.OrderDTO;
import com.abhi.myntra.entity.Address;
import com.abhi.myntra.entity.Customer;
import com.abhi.myntra.entity.CustomerProfile;
import com.abhi.myntra.entity.Order;
import com.abhi.myntra.mappers.CustomerMapper;
import com.abhi.myntra.repository.CustomerProfileRepository;
import com.abhi.myntra.repository.CustomerRepository;
import com.abhi.myntra.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    private CustomerProfileRepository customerProfileRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerProfileRepository customerProfileRepository) {
        this.customerRepository = customerRepository;
        this.customerProfileRepository = customerProfileRepository;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO);
        customer.setCreatedBy(customerDTO.getFirstName() + " " + customerDTO.getLastName());
        if (customerDTO.getCustomerProfileDTO() != null) {
            CustomerProfile customerProfile = CustomerMapper.mapToCustomerProfile(customerDTO.getCustomerProfileDTO());
            customer.setCustomerProfile(customerProfile);
            customerProfile.setCustomer(customer);
           // customerProfileRepository.save(customerProfile);
        }
        if (customerDTO.getAddressDTOList() != null) {
            List<AddressDTO> addressDTOList = customerDTO.getAddressDTOList();
            List<Address> addressList = addressDTOList.stream().map(CustomerMapper::mapToAddress).collect(Collectors.toList());
            customer.setAddress(addressList);

            for (Address address : addressList){
                address.setCustomer(customer);
            }
        }

        if (customerDTO.getOrderDTOList() != null){
            List<OrderDTO> orderDTOList = customerDTO.getOrderDTOList();
            List<Order> orderList = orderDTOList.stream().map(CustomerMapper::mapToOrder).collect(Collectors.toList());
            customer.setOrders(orderList);

           /* for (Order order : orderList){
                order.getCustomers().
            }*/

        }

       Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDTO(savedCustomer);
    }


    @Override
    public List<CustomerDTO> findAllCustomers() {
        return null;
    }

    @Override
    public CustomerDTO findCustomerById(Long id) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        return null;
    }
}
