package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();
	
    public Optional<Employee> getEmployeeById(Long id) throws IdNotFoundException;
	
	public Employee saveEmployee(Employee employee);
	
	public Employee updateEmployee(Long id, Employee employee);
	
	public String deleteEmployee();
	
	public String deleteEmployeeById(Long id);
}
