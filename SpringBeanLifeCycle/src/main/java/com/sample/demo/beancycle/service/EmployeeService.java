package com.sample.demo.beancycle.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.sample.demo.beancycle.model.Employee;

public class EmployeeService implements InitializingBean, DisposableBean{

	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public EmployeeService() {
		System.out.println("Default constructor for Employee Service");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Bean destroyed. closing resources");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing the bean through service");
		if(employee.getEmpId() == 0 && employee.getEmpName() == null) {
			employee.setEmpId(1);
			employee.setEmpName("Rakesh");
		}
	}

}
