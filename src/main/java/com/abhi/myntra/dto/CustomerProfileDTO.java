package com.abhi.myntra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProfileDTO {
    private Long id;
    private Long mobileNumber;
    private String gender;
}
