package com.sample.boot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.boot.entity.BalanceLeave;
import com.sample.boot.entity.Leave;

@Repository
public class BalanceLeaveRepositoryImpl implements BalanceLeaveRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<BalanceLeave> getAllBalance() {
		String sql = "select * from balanceleave";
		
		List<BalanceLeave> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(BalanceLeave.class));
		return list;
	}

	@Override
	public int save(BalanceLeave b) {
		// TODO Auto-generated method stub
		String sql = "insert into balanceleave value (?, ?, ?)";
		BalanceLeave bl = getLastRow();
		
		int id = 1001;
		if(bl != null) {
			id = bl.getBalId() + id;
		}
		b.setBalId(id);
		Object[] args = {b.getBalId(),b.getLeavebalance(), b.getEmpId()};
		int res = jdbcTemplate.update(sql, args);
		return res;
	}

	private BalanceLeave getLastRow() {
		// TODO Auto-generated method stub
		String sql = "select * from balanceleave order by balid desc limit 1";
		BalanceLeave b = null;
		try {
			b = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(BalanceLeave.class));
		} catch (Exception e) {
			System.out.println("leave balance updated");
		}
		return null;
	}

	@Override
	public BalanceLeave getBalanceById(int id) {
		String sql = "select * from balanceleave where balid = ?";
		BalanceLeave bl = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(BalanceLeave.class), id);
	
		return bl;
	}

}
