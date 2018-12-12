package com.cg.employeecodemodule.dao;

import java.util.List;

import com.cg.employeecodemodule.models.Employee;

public interface IEmployeeDao {

	Employee createData(Employee employee);

	Employee updateData(Employee employee);

	List<Employee> readAll();

	Employee deleteData(int employeeId);

	Employee readData(int employeeId);

}
