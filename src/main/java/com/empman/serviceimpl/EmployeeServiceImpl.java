package com.empman.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empman.dao.EmployeeDao;
import com.empman.entity.Employee;
import com.empman.service.EmployeeService;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeDao employeeDao;
	@Override
	public Boolean saveEmployee(Employee employee) 
	{
		Boolean isSaved=false;
		Employee emp1= employeeDao.save(employee);
		if(emp1!=null)
			isSaved=true;
		else
			isSaved=false;
		return isSaved;
			
	}
	
	@Override
	public Boolean updateEmployee(Employee employee) 
	{
		Boolean isSaved=false;
		Employee emp1= employeeDao.save(employee);
		if(emp1!=null)
			isSaved=true;
		else
			isSaved=false;
		return isSaved;
		
		
	}

//	@Override
//	public Employee getEmployeeById(int empId) 
//	{
//		Employee employee = employeeDao.getById(null);		
//		return employee;
//	}

	@Override
	public Optional<Employee> getEmployeeById(int empId) 
	{
		Optional<Employee> employee = employeeDao.findById(empId);  //Latest version	
		return employee;
	}
	@Override
	public List<Employee> getAllEmployee() 
	{
		List<Employee> empList = employeeDao.findAll();
		return empList;
	}

	@Override
	public void deleteEmployeeById(int empId) 
	{
		employeeDao.deleteById(empId);
		System.out.println("Employee Deleted");
		
	}

//	@Override
//	public List<Employee> getEmployeeByName(String empName) {
//		employeeDao.findAllById(empName);
//		return null;
//	}

	
}
