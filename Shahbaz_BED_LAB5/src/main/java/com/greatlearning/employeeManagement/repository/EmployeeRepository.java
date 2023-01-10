package com.greatlearning.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greatlearning.employeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
