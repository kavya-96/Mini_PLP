package com.cg.employeecodemodule.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cg.employeecodemodule.exceptions.IDExistsException;
import com.cg.employeecodemodule.models.Employee;



@Repository
public class EmployeeDaoIMPL implements IEmployeeDao{
	
	@Autowired
	MongoTemplate mongotemplate;
	

	@Override
	public Employee createData(Employee employee) {
		employee.setEmployeeId(employee.getEmployeeId());
		return mongotemplate.insert(employee);
	}

	@Override
	public Employee updateData(Employee employee) {
		Employee detail=readData(employee.getEmployeeId());
		if(detail!=null){
	mongotemplate.save(employee);
		}else{
			throw new IDExistsException("Nothing to modify");
		}
		return employee;
		/*String employeeId = String.valueOf(employee.getEmployeeId());
		Employee employee2 =mongotemplate.findOne(employeeId);
		if(employee2.equals(null)){
			throw new IDExistsException("Entered Employee Id is Wrong"); 
		}
		return mongotemplate.save(employee);*/
	}

	@Override
	public List<Employee> readAll() {
		return mongotemplate.findAll(Employee.class);
	}

	@Override
	public Employee deleteData(int employeeId) {
		Employee detail=readData(employeeId);
		if(detail!=null){
			mongotemplate.remove(detail);
		}
		return detail;
	}

	@Override
	public Employee readData(int employeeId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(employeeId));
		Employee details=mongotemplate.findOne(query, Employee.class);
		return details;
	}

}
