package com.empman;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.empman.dao.EmployeeDao;
import com.empman.entity.Employee;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmpManageApplicationTests 
{
	@Autowired
	EmployeeDao employeeDao;
	
	@Test
	@Order(1)
	public void testSaveEmployee()
	{
		Employee empTest=new Employee(0,"Ramesh Nikam","Hingoli", 90000, "Team Lead");
		employeeDao.save(empTest);
		assertNotNull(employeeDao.findById(11).get());
	}

	@Test
	@Order(2)
	public void testUpdateEmployee()
	{
		Employee empTest=new Employee(11,"Ramesh Nikam","Nanded", 90000, "Team Lead");
		employeeDao.save(empTest);
		assertNotNull(employeeDao.findById(11).get());
	}
	
	@Test
	@Order(3)
	public void testGetEmpById()
	{
		Optional<Employee> empDb = employeeDao.findById(11);
		assertEquals("Nanded",empDb.get().getEmpAddress());
	}
	
	@Test
	@Order(4)
	public void testGetAllEmp()
	{
		 List<Employee> empList = employeeDao.findAll();
		assertThat(empList).size().isGreaterThan(4);  // or >0
	}
	
	@Test
	@Order(5)
	public void testDeleteEmpById()
	{
		employeeDao.deleteById(11);
		assertThat(employeeDao.existsById(8)).isFalse();  
	}
	
}
