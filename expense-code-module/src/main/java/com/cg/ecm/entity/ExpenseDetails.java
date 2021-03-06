package com.cg.ecm.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "expensedetails")
public class ExpenseDetails {
	@Id
	private int expenseCode;

	@NotNull
	@Field(value = "expense_type")
	@Size(min=3,max=15, message="Name should have atleast 3 characters")
	private String expenseType;

	@NotNull
	@Field(value = "expense_description")
	@Size(min=15,max=100, message="Name should have atleast 15 characters")
	private String expenseDescription;
	public int getExpenseCode() {
		return expenseCode;
	}
	public void setExpenseCode(int expenseCode) {
		this.expenseCode = expenseCode;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getExpenseDescription() {
		return expenseDescription;
	}
	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}
	@Override
	public String toString() {
		return "ExpenseDetails [expenseCode=" + expenseCode + ", expenseType="
				+ expenseType + ", expenseDescription=" + expenseDescription
				+ "]";
	}
	public ExpenseDetails(int expenseCode, String expenseType,
			String expenseDescription) {
		super();
		this.expenseCode = expenseCode;
		this.expenseType = expenseType;
		this.expenseDescription = expenseDescription;
	}
	public ExpenseDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
