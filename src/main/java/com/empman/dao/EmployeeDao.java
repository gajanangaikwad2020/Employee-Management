package com.empman.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empman.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>
{

}
