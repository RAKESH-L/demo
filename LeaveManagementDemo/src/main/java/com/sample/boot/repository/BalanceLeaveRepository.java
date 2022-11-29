package com.sample.boot.repository;

import java.util.List;

import com.sample.boot.entity.BalanceLeave;

public interface BalanceLeaveRepository {

	public List<BalanceLeave> getAllBalance();
	public int save(BalanceLeave b);
	
	public BalanceLeave getBalanceById(int id);
}
