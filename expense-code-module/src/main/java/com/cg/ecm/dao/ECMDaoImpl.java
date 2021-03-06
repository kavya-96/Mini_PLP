package com.cg.ecm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cg.ecm.entity.ExpenseDetails;
import com.cg.ecm.exception.ECMException;
@Repository
public class ECMDaoImpl implements EMCDao{
@Autowired
	MongoTemplate mongotemplate;
	@Override
	public ExpenseDetails addDetails(ExpenseDetails expdetails) throws ECMException {
		ExpenseDetails detail=getByCode(expdetails.getExpenseCode());
		if(detail==null){
		mongotemplate.save(expdetails);
		}else{
			throw new ECMException("ExpenseCode already exists");
		}
		return expdetails;
	}
	@Override
	public List<ExpenseDetails> getAllDetails() throws ECMException {
		List<ExpenseDetails> list=mongotemplate.findAll(ExpenseDetails.class);
		/*try{*/
			
		if(!list.isEmpty()){
			return list;
		}else{
			throw  new ECMException("NO DATA TO DISPLAY!!");
		}	
		/*}
	catch (ECMException e) {
			System.err.println(e.getMessage());
		}*/
		
	}
	@Override
	public ExpenseDetails getByCode(int expenseCode) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(expenseCode));
		ExpenseDetails details=mongotemplate.findOne(query, ExpenseDetails.class);
		return details;
	}
	@Override
	public ExpenseDetails DeleteByCode(int expenseCode) {
		ExpenseDetails detail=getByCode(expenseCode);
		if(detail!=null){
			mongotemplate.remove(detail);
		}
		return detail;
		
	}
	@Override
	public ExpenseDetails updateDetails(ExpenseDetails expdetails) throws ECMException {
		ExpenseDetails detail=getByCode(expdetails.getExpenseCode());
		if(detail!=null){
	mongotemplate.save(expdetails);
		}else{
			throw new ECMException("Nothing to modify");
		}
		return expdetails;
	}

}
