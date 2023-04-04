package com.empman.serviceimpl;

import java.util.ArrayList;
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
	public boolean deleteEmployeeById(int empId) 
	{
		boolean isDeleted=false;
		Optional<Employee> empExist = employeeDao.findById(empId);
		if(empExist.isPresent())
		{
			employeeDao.deleteById(empId);
			isDeleted=true;
		}	
		
		return isDeleted;
			
//		System.out.println("Employee Deleted");
		
	}

	@Override
	public List<Employee> getEmployeeByName(String empName) {
		List<Employee> findAll = employeeDao.findAll();
		List<Employee> empListByName=new ArrayList<>();
		for (Employee employee : findAll) 
		{
			if(employee.getEmpName().equals(empName))
			{
				empListByName.add(employee);
			}
		}
		return empListByName;
	}

	
}
