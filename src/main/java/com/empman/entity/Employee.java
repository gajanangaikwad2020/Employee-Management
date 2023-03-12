package com.empman.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="Emp_Id")
	private int empId;
	
//	@Column(name="Emp_Name")
//	@NotNull(message = "Employee name is Required")
	private String empName;	
	
//	@Column(name="Emp_Address")
//	@NotNull(message = "Employee Address is Required")
	private String empAddress;
	
//	@Column(name="Emp_Salary")
//	@Min(1)
	private double salary;
	
//	@Column(name="Emp_Dept")
//	@NotNull(message = "Employee Department is Required")
	private String empDept;
	
	


}
