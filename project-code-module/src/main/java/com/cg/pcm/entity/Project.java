package com.cg.pcm.entity;

import java.util.Date;



import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;
@Document
public class Project {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Field(value="project_code")
	private int productCode;
	@Pattern(regexp="[A-Z]{1}[A-Za-z+\\s]{2,}")
	@Field(value="project_description")
	private String projectDescription;
	@Field(value="start_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date startDate;
	@Field(value="end_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date endDate;

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Project(int productCode, String projectDescription,
			Date startDate, Date endDate) {
		super();
		this.productCode = productCode;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Project() {
	}

}
