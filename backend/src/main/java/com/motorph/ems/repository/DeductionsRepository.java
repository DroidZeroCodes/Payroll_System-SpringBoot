package com.motorph.ems.repository;

import com.motorph.ems.model.Deductions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeductionsRepository  extends JpaRepository<Deductions, Long> {
}
