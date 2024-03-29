package com.abhi.myntra.dto;

import com.abhi.myntra.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id","firstName","lastName","email","password"})
public class CustomerDTO extends BaseEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private CustomerProfileDTO customerProfileDTO;
    private List<AddressDTO> addressDTOList;
    private List<OrderDTO> orderDTOList;

}
