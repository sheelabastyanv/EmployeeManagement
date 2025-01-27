package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFound;

//import org.springframework.stereotype.Service;

//@Service
public interface EmployeeService {

	public abstract String addEmployee(Employee employee);

	public abstract Employee updateEmployee(Employee employee);

	public abstract String deleteEmployee(int empId);

	public abstract Employee getEmployee(int empId) throws EmployeeNotFound;

	public abstract List<Employee> getAllEmployee();

	public abstract List<Employee> getAllBetweenSalaries(int initialSal, int finalSal);

	List<Employee> getAllByDesg(String empDesg);

}
