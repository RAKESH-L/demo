package com.sample.boot.repository;

import java.util.List;

import com.sample.boot.entity.Employee;

public interface EmployeeRepository {

	public List<Employee> getAllEmployee();
	public int save(Employee e);
}
