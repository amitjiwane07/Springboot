package com.example.demo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	
	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		return Optional.of(employeeRepository.findById(id).orElseThrow(()->new IdNotFoundException("id not present")));
	}
	

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	
	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee existingEmployee=employeeRepository.findById(id).get();
		existingEmployee.setEmpName(employee.getEmpName());
		existingEmployee.setDepartment(employee.getDepartment());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setAddress(employee.getAddress());
		return employeeRepository.save(existingEmployee);
	}
	
	@Override
	public String deleteEmployee() {
		employeeRepository.deleteAll();
		return "deleted";
	}

	@Override
	public String deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		return null;
	}

	

}
