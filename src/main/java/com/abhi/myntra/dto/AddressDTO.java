package com.abhi.myntra.dto;

import com.abhi.myntra.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

        private Long id;
        private String landMark;
        private String location;
        private String state;
        private String pincode;
}
