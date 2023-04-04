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
		Employee empTest=new Employee(0,"Yadav Mane","Nagpur", 75000, "Admin");
		employeeDao.save(empTest);
		assertNotNull(employeeDao.findById(15).get());
	}

	@Test
	@Order(2)
	public void testUpdateEmployee()
	{
		Employee empTest=new Employee(15,"Yadav Mane","Nagpur", 70000, "Admin");
		employeeDao.save(empTest);
		assertNotNull(employeeDao.findById(15).get());
	}
	
	@Test
	@Order(3)
	public void testGetEmpById()
	{
		Optional<Employee> empDb = employeeDao.findById(15);
		assertEquals("Nagpur",empDb.get().getEmpAddress());
	}
	
	@Test
	@Order(4)
	public void testGetAllEmp()
	{
		 List<Employee> empList = employeeDao.findAll();
		 assertThat(empList).size().isGreaterThan(6);  // or >0
	}
	
	@Test
	@Order(5)
	public void testDeleteEmpById()
	{
		employeeDao.deleteById(15);
		assertThat(employeeDao.existsById(15)).isFalse();  
	}
	
}
