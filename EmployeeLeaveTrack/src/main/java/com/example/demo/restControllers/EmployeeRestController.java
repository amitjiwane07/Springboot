package com.example.demo.restControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.serviceImple.EmployeeServiceImple;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeServiceImple employeeServiceImple;
	
	//Get all employee
	@GetMapping("/get")
	public List<Employee> obtainAllEmployee(){
		return employeeServiceImple.getAllEmployee();
	}
	
	//Get employee by ID
	@GetMapping("/get/{id}")
	public Optional<Employee> obtainEmployeeById(@PathVariable Long id){
		return employeeServiceImple.getEmployeeById(id);
	}
	
	//save EmployeeDetails
	@PostMapping("/post")
	public Employee storeEmployee(@RequestBody Employee employee) {
		return employeeServiceImple.saveEmployee(employee);
	}
	
	//update Employee
	@PutMapping("/update/{id}")
	public Employee modifyEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		return employeeServiceImple.updateEmployee(id, employee);
	}
	
	//Delete all employee
	@DeleteMapping("/delete")
	public String eraseEmployee() {
		employeeServiceImple.deleteEmployee();
		return "Deleted Successfully";
	}
	
	//Delete employee by ID
	@DeleteMapping("/delete/{id}")
	public String eraseEmployeeById(@PathVariable Long id) {
		employeeServiceImple.deleteEmployeeById(id);
		return "Deleted "+id;
	}
}
