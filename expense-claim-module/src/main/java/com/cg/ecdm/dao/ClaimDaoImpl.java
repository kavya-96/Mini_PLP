package com.cg.ecdm.dao;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cg.ecdm.exceptions.ECMException;
import com.cg.ecdm.models.ClaimBean;

@Repository
public class ClaimDaoImpl implements IClaimDao{
	
	@Autowired
	MongoTemplate template;
	
	public static int autoGenerate(){
		Random rand=new Random();
		int n=100000+rand.nextInt(900000);
		return n;
	} 
	

	@Override
	public ClaimBean addClaimDetails(ClaimBean claim) {
		claim.setClaimCode(autoGenerate());
		template.save(claim);
		return claim;
	}


	@Override
	public ClaimBean getById(int claimCode) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(claimCode));
		if(template.findOne(query, ClaimBean.class)==null){
			try {
				throw new ECMException("No such Id exists to delete"+claimCode);
			} catch (ECMException e) {
				e.printStackTrace();
			}
		}
		return template.findOne(query, ClaimBean.class);
	}


	@Override
	public void deleteClaim(ClaimBean bean) {
		Query query = new Query();
		System.out.println(bean.getClaimCode());
		query.addCriteria(Criteria.where("_id").is(bean.getClaimCode()));
		ClaimBean bean2 = template.findOne(query, ClaimBean.class);
		if(bean2==null){
			try {
				throw new ECMException("No such Id exists to delete"+bean.getClaimCode());
			} catch (ECMException e) {
				e.printStackTrace();
			}
		}
		template.remove(bean2);
	}

}
