package com.greatlearning.employeeManagement.service;

import java.util.List;

import com.greatlearning.employeeManagement.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public void saveOrUpdate(Employee theEmployee);

	public Employee getEmployeeById(int theId);

	public void deleteEmployeeById(int theId);

}
