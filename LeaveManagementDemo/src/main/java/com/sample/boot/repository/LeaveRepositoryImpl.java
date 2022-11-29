package com.sample.boot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.boot.entity.Leave;

@Repository
public class LeaveRepositoryImpl implements LeaveRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Leave l) {
		// TODO Auto-generated method stub
		String sql = "insert into empleave value (?, ?, ?, ?, ?, ?)";
		Leave leave = getLastRow();
		
		int id = 101;
		if(leave != null) {
			id = leave.getLeaveId() + 1;
		}
		l.setEmployeeid(id);
		Object[] args = {l.getLeaveId(), l.getStartDate(), l.getEndDate(),
				l.getLeaveType(), l.getNod(), l.getEmployeeid()};
		int res = jdbcTemplate.update(sql, args);
		return res;
	}

	private Leave getLastRow() {
		// TODO Auto-generated method stub
		String sql = "select * from empleave order by leaveid desc limit 1";
		Leave l = null;
		try {
			l = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Leave.class));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Leave Updated");
		}
		return null;
	}

	@Override
	public List<Leave> getAllLeave() {
		String sql = "select * from empleave";
		
		List<Leave> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Leave.class));
		return list;
	}

	@Override
	public Leave cancelLeave(int id) {
		String sql = "DELETE FROM EMPLEAVE WHERE LEAVEID = ?";
		int res = jdbcTemplate.update(sql, id);
		if(res > 0) {
			System.out.println("Deleted leave with id " + id);
		} else {
			System.out.println("Unable to delete leave with id " + id);
		}
		return null;
		
	}

}
