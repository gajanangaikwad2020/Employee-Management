package com.empman.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empman.entity.Employee;
import com.empman.exception.InvalidCredentialsException;
import com.empman.exception.ResourceNotFoundException;
import com.empman.service.EmployeeService;
@RestController
@RequestMapping(value="employee")
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value="/save-emp")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) 
	{
		Boolean isSaved= employeeService.saveEmployee(employee);
		if(isSaved)
		{
			return new ResponseEntity<String>("Employee is Saved.",HttpStatus.CREATED);
		}
		else
		{
			throw new InvalidCredentialsException("Invalid Credentials For Employee-Id ->"+employee.getEmpId());
		}
		
	}
	
	@PutMapping(value="/update-emp")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) 
	{
		Boolean isUpdated= employeeService.updateEmployee(employee);
		if(isUpdated)
		{
			return new ResponseEntity<String>("Employee is updated.",HttpStatus.CREATED);
		}
		else
		{
			throw new ResourceNotFoundException("Employee Not Found For Update with Employee id :->"+employee.getEmpId());
		}
		
	}
	
	@GetMapping(value="/get-emp-by-id/{empId}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int empId) 
	{
		Optional<Employee> employee= employeeService.getEmployeeById(empId);
		if(employee.isPresent())    // isPresent() check record is present or not
		{
			return new ResponseEntity<Optional<Employee>>(employee,HttpStatus.OK);
		}
		else
		{
			throw new ResourceNotFoundException("Employee Not Found with Employee-id -> "+empId);
		}
		
	}
	
	@GetMapping(value="/get-all-employee")
	public ResponseEntity<List<Employee>> getAllEmployee() 
	{
		List<Employee> employeeList= employeeService.getAllEmployee();
		if(!employeeList.isEmpty())
		{
			return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
		}
		else
		{
			throw new ResourceNotFoundException("Employee List Not Found");
		}	
	}
	
	@DeleteMapping(value="/delete-emp-by-id/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int empId) 
	{
		employeeService.deleteEmployeeById(empId);
//		if(isDeleted)
//		{
			return new ResponseEntity<String>("Employee is Deleted Whose Id  ::"+empId,HttpStatus.OK);
//		}
//		else
//		{
//			throw new ResourceNotFoundException("Employee is Not Found For Delete Employee id ::"+empId);
//		}
		
	}
	
//	@GetMapping(value="/get-emp-by-name/{name}")
//	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name) 
//	{
//		List<Employee> employee= employeeService.getEmployeeByName(name);
//		if(employee!=null)
//		{
//			return new ResponseEntity<List<Employee>>(employee,HttpStatus.OK);
//		}
//		else
//		{
//			throw new ResourceNotFoundException("Employee Not FOund For Employee name  :"+name);
//		}
//		
//	}
	

}
