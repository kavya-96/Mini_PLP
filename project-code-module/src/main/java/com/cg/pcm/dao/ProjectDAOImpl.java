package com.cg.pcm.dao;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;




import com.cg.pcm.entity.Project;
import com.cg.pcm.exception.UserNotFoundException;

@Repository
public class ProjectDAOImpl implements IProjectDAO {
	
	@Autowired
	MongoTemplate mongotemplate;
	
	@Override
	public Project insertData(@Valid Project project) {
		long startDateSecs=project.getStartDate().getTime();
		long endDateSecs=project.getEndDate().getTime();
		long diff=startDateSecs-endDateSecs;
		if(diff>=0){
			throw new UserNotFoundException("End date should be greater than start date");
		}
		mongotemplate.save(project);
		return project;
	}

	@Override
	public List<Project> getAllDetails() {
		List<Project> list=mongotemplate.findAll(Project.class);
	
			
		if(!list.isEmpty()){
			return list;
		}else{
			throw  new UserNotFoundException("NO DATA TO DISPLAY!!");
		}	
		//TypedQuery<Project> query=mongo.createQuery("select p from Project p",Project.class);
	
	}

	@Override
	public Project getDetailsById(int id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Project details=mongotemplate.findOne(query, Project.class);
		return details;
	}

	@Override
	public Project updateDetailsById(int id, Project project) {
		Project detail=getDetailsById(id);
		if(detail!=null){
	mongotemplate.save(project);
		}else{
			throw new UserNotFoundException("Nothing to modify");
		}
		return project;
		/*project.setProductCode(id);
		System.out.println(project.getStartDate()+""+project.getEndDate());
		Project projects=mongo.find(Project.class, id);
		if(project.getStartDate()==null){
			project.setStartDate(projects.getStartDate());
		}
		if(project.getProjectDescription().equals("")){
			project.setProjectDescription(projects.getProjectDescription());
		}
		if(project.getEndDate()==null){
			project.setEndDate(projects.getEndDate());
		}
		if(projects==null){
			throw new UserNotFoundException("No such id present : "+id);
		}
		//project.setProjectDescription(projects.getProjectDescription());
		mongo.merge(project);
		mongo.flush();
	
		return project;*/
	}

	@Override
	public Project deleteDetailsById(int id) {
		Project detail=getDetailsById(id);
		if(detail!=null){
			mongotemplate.remove(detail);
		}
		return detail;
	}

}
