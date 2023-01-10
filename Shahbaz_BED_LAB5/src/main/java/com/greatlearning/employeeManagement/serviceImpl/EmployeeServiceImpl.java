package com.greatlearning.employeeManagement.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeeManagement.entity.Employee;
import com.greatlearning.employeeManagement.repository.EmployeeRepository;
import com.greatlearning.employeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public List<Employee> getAllEmployees() {

		return repository.findAll();
	}

	@Override
	public void saveOrUpdate(Employee theEmployee) {

		repository.save(theEmployee);
	}

	@Override
	public Employee getEmployeeById(int theId) {

		return repository.findById(theId).get();
	}

	@Override
	public void deleteEmployeeById(int theId) {

		Employee emp = getEmployeeById(theId);
		repository.delete(emp);
	}

}