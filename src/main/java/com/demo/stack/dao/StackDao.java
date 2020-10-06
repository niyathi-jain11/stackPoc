package com.demo.stack.dao;

import java.util.List;

import com.demo.stack.model.Employee;

public interface StackDao {
	
	Employee pushEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long employeeId);

	void popEmployee();
}