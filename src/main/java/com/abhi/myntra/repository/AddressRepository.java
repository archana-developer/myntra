package com.abhi.myntra.repository;

import com.abhi.myntra.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
