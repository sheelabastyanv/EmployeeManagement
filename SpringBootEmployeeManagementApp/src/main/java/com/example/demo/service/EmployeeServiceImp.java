package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
//import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFound;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String addEmployee(Employee employee) {
		Employee emp= employeeRepository.save(employee);
		if(emp!=null)
		
		return "Employee saved successfully";
		else
			return "Failed to save Employee";
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee emp= employeeRepository.save(employee);
		if(emp!=null)
		
		return emp;
		else
			
		   return null;
	}

	@Override
	public String deleteEmployee(int empId) {
		   employeeRepository.deleteById(empId);
		return "Employee Deleted Successfully";
	}

	@Override
	public Employee getEmployee(int empId) throws EmployeeNotFound{
	Optional<Employee> optional=employeeRepository.findById(empId);
	if(optional.isPresent())
		return optional.get();
	else
		throw new EmployeeNotFound("No Employee Found WIth Given Id!!");
	}

	@Override
	public List<Employee> getAllEmployee() {
	return	employeeRepository.findAll();
		
	}

	@Override
	public List<Employee> getAllBetweenSalaries(int initialSal, int finalSal) {
		return employeeRepository.getAllBetweenSalaries(initialSal,finalSal);
	
	}
	@Override
	public List<Employee> getAllByDesg(String empDesg) {
	return	employeeRepository.getAllByDesg(empDesg);
		
	}

}
