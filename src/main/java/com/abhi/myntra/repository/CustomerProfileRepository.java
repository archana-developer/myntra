package com.abhi.myntra.repository;

import com.abhi.myntra.entity.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile,Long> {
}
