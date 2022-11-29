package com.sample.boot.repository;

import java.util.List;

import com.sample.boot.entity.Leave;

public interface LeaveRepository {

	public int save(Leave l);
	public List<Leave> getAllLeave();
	public Leave cancelLeave(int id);
}
