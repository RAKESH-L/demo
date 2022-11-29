package com.sample.boot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.boot.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		String sql = "select * from employee";
		List<Employee> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
		return list;
	}

	@Override
	public int save(Employee e) {
		String sql = "insert into employee value (?, ?, ?, ?, ?)";
		Employee emp = getLastRow();
		
		int id = 101;
		if(emp != null) {
			id = emp.getEmpId() + id;
		}
		e.setEmpId(id);
		Object[] args = {e.getEmpId(), e.getEmpName(), e.getEmail(), e.getContact(),
				e.getDoj()};
		int res = jdbcTemplate.update(sql, args);
		
		return res;
	}

	private Employee getLastRow() {
		String sql = "select * from employee order by empid desc limit 1";
		Employee e = null;
		try {
			e = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class));
			
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Employee Inserted");
		}
		return null;
	}
}
