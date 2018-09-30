package com.starstel.telcopro.rh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.rh.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{
	
}
