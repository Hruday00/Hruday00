package org.project.jobportal;

import java.util.LinkedList;
import java.util.List;

public class Job {
	
	private String companyName;
	private String jobTitle;
	private String language;
	private String employment;
	private String jobDescription;
	private String jobLocation;
	private String employerId;
	private String jobId;
	
	public Job() {
		super();
	}


	public Job(String companyName, String jobTitle, String language, String employment, String jobDescription,
			String jobLocation, String employerId, String jobId) {
		super();
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.language = language;
		this.employment = employment;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		this.employerId = employerId;
		this.jobId = jobId;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getEmployment() {
		return employment;
	}
	public void setEmployment(String employment) {
		this.employment = employment;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getEmployerId() {
		return employerId;
	}
	public void setEmployerId(String employerId) {
		this.employerId = employerId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

}
