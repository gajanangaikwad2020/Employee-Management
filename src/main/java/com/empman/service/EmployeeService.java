package com.empman.service;

import java.util.List;
import java.util.Optional;

import com.empman.entity.Employee;

public interface EmployeeService 
{
	public Boolean saveEmployee(Employee employee);

	public Boolean updateEmployee(Employee employee);

	public Optional<Employee> getEmployeeById(int empId);

	public List<Employee> getAllEmployee();

	public void deleteEmployeeById(int empId);

	
//	public List<Employee> getEmployeeByName(String name); 

}
