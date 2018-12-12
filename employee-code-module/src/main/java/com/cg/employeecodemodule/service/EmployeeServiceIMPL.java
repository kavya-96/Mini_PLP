package com.cg.employeecodemodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeecodemodule.dao.IEmployeeDao;
import com.cg.employeecodemodule.models.Employee;

@Service
public class EmployeeServiceIMPL implements IEmployeeService{
	
	@Autowired
	IEmployeeDao employeeDao;

	@Override
	public Employee createData(Employee employee) {
		return employeeDao.createData(employee);
	}

	@Override
	public Employee updateData(int employeeId, Employee employee) {
		employee.setEmployeeId(employeeId);
		return employeeDao.updateData(employee);
	}

	@Override
	public List<Employee> readAll() {
		return employeeDao.readAll();
	}

	@Override
	public Employee deleteData(int employeeId) {
		return employeeDao.deleteData(employeeId);
	}

	@Override
	public Employee readData(int employeeId) {
		return employeeDao.readData(employeeId);
	}
	
}
