package com.greatlearning.employeeManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.employeeManagement.entity.Employee;
import com.greatlearning.employeeManagement.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/list")
	public String getAllEmployees(Model model) {
		List<Employee> result = employeeService.getAllEmployees();
		model.addAttribute("employees", result);
		return "employees/list-employee";
	}

	@GetMapping("/new")
	public String addNewEmployees(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "employees/add-emp";
	}

	@GetMapping("/edit/{id}")
	public String editEmployees(Model model, @PathVariable("id") Integer id) {
		Employee emp = employeeService.getEmployeeById(id);
		model.addAttribute("employee", emp);
		return "employees/edit-form";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployees(@PathVariable("id") Integer id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees/list";
	}

	@PostMapping("/save")
	public String saveEmployees(@ModelAttribute(name = "employee") Employee emp) {
		employeeService.saveOrUpdate(emp);
		return "redirect:/employees/list";
	}

	@PostMapping("/employee/{id}")
	public String updateEmployees(@ModelAttribute(name = "employee") Employee emp, @PathVariable("id") Integer id) {

		Employee empEx = employeeService.getEmployeeById(id);

		if (empEx.getId() == emp.getId()) {
			empEx.setFirstName(emp.getFirstName());
			empEx.setLastName(emp.getLastName());
			empEx.setEmail(emp.getEmail());
		}
		employeeService.saveOrUpdate(emp);
		return "redirect:/employees/list";
	}

}
