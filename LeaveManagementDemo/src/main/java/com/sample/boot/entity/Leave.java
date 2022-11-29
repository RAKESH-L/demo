package com.sample.boot.entity;

public class Leave {

	private int leaveId;
	private String startDate;
	private String endDate;
	private String leaveType;
	private int nod;
	private int employeeid;

	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Leave(int leaveId, String startDate, String endDate, String leaveType, int nod, int employeeid) {
		super();
		this.leaveId = leaveId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaveType = leaveType;
		this.nod = nod;
		this.employeeid = employeeid;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public int getNod() {
		return nod;
	}

	public void setNod(int nod) {
		this.nod = nod;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	@Override
	public String toString() {
		return "Leave [leaveId=" + leaveId + ", startDate=" + startDate + ", endDate=" + endDate + ", leaveType="
				+ leaveType + ", nod=" + nod + ", employeeid=" + employeeid + "]";
	}

}
