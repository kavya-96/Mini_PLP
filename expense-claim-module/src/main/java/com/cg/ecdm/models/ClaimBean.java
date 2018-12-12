package com.cg.ecdm.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "claimbean")
public class ClaimBean {

	@Id
	private int claimCode;
	@NotEmpty(message="Shouldn't be empty")
	private int employeeId;
	@NotNull(message="Shouldn't be empty")
	private String employeeName;
	private int projectCode;
	private int expenseCode;
	@NotNull(message="Shouldn't be empty")
	private String startDate;
	@NotNull(message="Shouldn't be empty")
	private String endDate;
	@NotNull(message="Shouldn't be empty")
	private String expenseAmount;

	public int getClaimCode() {
		return claimCode;
	}

	public void setClaimCode(int claimCode) {
		this.claimCode = claimCode;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}

	public int getExpenseCode() {
		return expenseCode;
	}

	public void setExpenseCode(int expenseCode) {
		this.expenseCode = expenseCode;
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

	public String getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(String expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public ClaimBean() {
		// TODO Auto-generated constructor stub
	}

	public ClaimBean(int claimCode, int employeeId, String employeeName,
			int projectCode, int expenseCode, String startDate, String endDate,
			String expenseAmount) {
		super();
		this.claimCode = claimCode;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.projectCode = projectCode;
		this.expenseCode = expenseCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.expenseAmount = expenseAmount;
	}
	
}
