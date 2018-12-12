package com.cg.employeecodemodule.service;

import java.util.List;

import com.cg.employeecodemodule.models.Employee;

public interface IEmployeeService {

	Employee createData(Employee employee);

	Employee updateData(int employeeId, Employee employee);

	List<Employee> readAll();

	Employee deleteData(int employeeId);

	Employee readData(int employeeId);;

}
