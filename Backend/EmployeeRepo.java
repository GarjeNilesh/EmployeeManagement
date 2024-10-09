package com.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.crud.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  
	List<Employee> findEmployeesByEmail(@Param("email") String email);

    
    // You can add more query methods here as needed
}
