package com.abhi.myntra.mappers;

import com.abhi.myntra.dto.AddressDTO;
import com.abhi.myntra.dto.CustomerDTO;
import com.abhi.myntra.dto.CustomerProfileDTO;
import com.abhi.myntra.dto.OrderDTO;
import com.abhi.myntra.entity.Address;
import com.abhi.myntra.entity.Customer;
import com.abhi.myntra.entity.CustomerProfile;
import com.abhi.myntra.entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {
    public static CustomerDTO mapToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setCreatedDate(customer.getCreatedDate());
        customerDTO.setUpdatedDate(customer.getUpdatedDate());
        customerDTO.setCreatedBy(customer.getCreatedBy());
        customerDTO.setUpdatedBy(customer.getUpdatedBy());
        customerDTO.setCustomerProfileDTO(mapToCustomerProfileDTO(customer.getCustomerProfile()));

        List<Address> addressList = customer.getAddress();
        List<AddressDTO> addressDTOList = addressList.stream().map(CustomerMapper::mapToAddressDTO).collect(Collectors.toList());
        customerDTO.setAddressDTOList(addressDTOList);

        List<Order> ordersList = customer.getOrders();
        List<OrderDTO> orderDTOList = ordersList.stream().map(CustomerMapper::mapToOrderDTO).collect(Collectors.toList());
        customerDTO.setOrderDTOList(orderDTOList);

        return customerDTO;
    }

    public static Customer mapToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());
        customer.setCreatedDate(customerDTO.getCreatedDate());
        customer.setUpdatedDate(customerDTO.getUpdatedDate());
        customer.setCreatedBy(customerDTO.getCreatedBy());
        customer.setUpdatedBy(customerDTO.getUpdatedBy());
        customer.setCustomerProfile(mapToCustomerProfile(customerDTO.getCustomerProfileDTO()));

        List<AddressDTO> addressDTOList = customerDTO.getAddressDTOList();
        List<Address> addressList = addressDTOList.stream().map(CustomerMapper::mapToAddress).collect(Collectors.toList());
        customer.setAddress(addressList);

        List<OrderDTO> orderDTOList = customerDTO.getOrderDTOList();
        List<Order> orderList = orderDTOList.stream().map(CustomerMapper::mapToOrder).collect(Collectors.toList());
        customer.setOrders(orderList);

        return customer;
    }

    public static CustomerProfile mapToCustomerProfile(CustomerProfileDTO customerProfileDTO) {
        CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setId(customerProfileDTO.getId());
        customerProfile.setMobileNumber(customerProfileDTO.getMobileNumber());
        customerProfile.setGender(customerProfileDTO.getGender());
        return customerProfile;
    }

    public static CustomerProfileDTO mapToCustomerProfileDTO(CustomerProfile customerProfile) {
        CustomerProfileDTO customerProfileDTO = new CustomerProfileDTO();
        customerProfileDTO.setId(customerProfile.getId());
        customerProfileDTO.setMobileNumber(customerProfile.getMobileNumber());
        customerProfileDTO.setGender(customerProfile.getGender());
        return customerProfileDTO;
    }

    public static Address mapToAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setLandMark(addressDTO.getLandMark());
        address.setPincode(addressDTO.getPincode());
        address.setLocation(addressDTO.getLocation());
        address.setState(addressDTO.getState());
        // address.setCustomer(addressDTO.getCustomer());
        return address;
    }

    public static AddressDTO mapToAddressDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setLandMark(address.getLandMark());
        addressDTO.setPincode(address.getPincode());
        addressDTO.setLocation(address.getLocation());
        addressDTO.setState(address.getState());
        return addressDTO;
    }

    public static Order mapToOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setStatus(orderDTO.getStatus());
        order.setDate(orderDTO.getDate());
        return order;
    }

    public static OrderDTO mapToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setDate(order.getDate());
        return orderDTO;
    }
}
