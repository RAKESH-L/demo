package com.sample.boot.entity;

public class BalanceLeave {
	private int balId;
	private int leavebalance;
	private int empId;
	public BalanceLeave() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BalanceLeave(int balId, int leavebalance, int empId) {
		super();
		this.balId = balId;
		this.leavebalance = leavebalance;
		this.empId = empId;
	}
	public int getBalId() {
		return balId;
	}
	public void setBalId(int balId) {
		this.balId = balId;
	}
	public int getLeavebalance() {
		return leavebalance;
	}
	public void setLeavebalance(int leavebalance) {
		this.leavebalance = leavebalance;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "BalanceLeave [balId=" + balId + ", leavebalance=" + leavebalance + ", empId=" + empId + "]";
	}

	
}
