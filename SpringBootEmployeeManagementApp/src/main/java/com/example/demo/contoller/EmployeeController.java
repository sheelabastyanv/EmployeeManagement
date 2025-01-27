package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFound;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save") 
	public String saveEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);

	}
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);

	}
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int employeeId) {
		return employeeService.deleteEmployee(employeeId);

	}
	@GetMapping("/get/{id}")
	public Employee getEmployee(@PathVariable("id") int employeeId) throws EmployeeNotFound {
		return employeeService.getEmployee(employeeId);


	}
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();

	}
	@GetMapping("/getAllBetween/{sal1}/{sal2}")
	public List<Employee> getAllEmployeesBetween(@PathVariable("sal1") int initialSal,@PathVariable("sal2") int finalSal) {
		return employeeService.getAllBetweenSalaries(initialSal,finalSal);

	}
	@GetMapping("/getAllByDesg/{desg}")
	public List<Employee> getAllByDesg(@PathVariable("desg")String empDesg) {
		return employeeService.getAllByDesg(empDesg);

	}
	
	
}
