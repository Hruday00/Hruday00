package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.HomePage;
import model.Employer;
import model.Job;
import model.JobSeeker;

public class DatabaseProvider {
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public DatabaseProvider () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=hruday");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void retrieve() throws Exception {
		employerRetrieve();
		jobseekerRetrieve();
		jobRetrieve();
		jobApplicantRetrieve();
	}

	public void employerStore(Employer employer) throws SQLException {
		String employeestore = "insert into batchthree.employee values(?,?,?,?,?,?,?,?)";
		
		pstmt = con.prepareStatement(employeestore);
		pstmt.setString(1, employer.getName());
		pstmt.setString(2, employer.getPhone());
		pstmt.setString(3, employer.getEmail());
		pstmt.setString(4, employer.getPassword());
		pstmt.setString(5, employer.getCompanyName());
		pstmt.setString(6, employer.getCompanyType());
		pstmt.setString(7, employer.getJob());
		pstmt.setString(8, employer.getEmployerId());
		pstmt.executeUpdate();
		
	}

	public void jobseekerStore(JobSeeker jobseeker) throws SQLException {
		String jobseekerstore = "insert into batchthree.jobseeker values(?,?,?,?,?,?,?)";
	
		pstmt = con.prepareStatement(jobseekerstore);
		pstmt.setString(1,jobseeker.getName());
		pstmt.setString(2,jobseeker.getPassword());
		pstmt.setString(3,jobseeker.getEmail());
		pstmt.setString(4,jobseeker.getPhone());
		pstmt.setString(5,jobseeker.getExperience());
		pstmt.setString(6,jobseeker.getCity());
		pstmt.setString(7,jobseeker.getjobSeekerId());
		pstmt.executeUpdate();
		
	}

	public void jobstore(Job job) throws SQLException {
		String jobstore = "insert into jobs values(?,?,?,?,?,?,?,?)";
	
		pstmt = con.prepareStatement(jobstore);
		pstmt.setString(1,job.getCompanyName());
		pstmt.setString(2,job.getJobTitle());
		pstmt.setString(3,job.getLanguage());
		pstmt.setString(4,job.getEmployment());
		pstmt.setString(5,job.getJobDescription());
		pstmt.setString(6,job.getJobLocation());
		pstmt.setString(7,job.getEmployerId());
		pstmt.setString(8,job.getJobId());
		pstmt.executeUpdate();
	
	}

	public void jobApplicantStore(JobSeeker js, String jobid) throws SQLException {
		
		String jobApplicantStore = "insert into batchthree.jobapplicants values(?,?,?,?,?,?,?,?)";
	
		pstmt = con.prepareStatement(jobApplicantStore);
		pstmt.setString(1, js.getName());
		pstmt.setString(2, js.getEmail());
		pstmt.setString(3, js.getPassword());
		pstmt.setString(4, js.getPhone());
		pstmt.setString(5, js.getExperience());
		pstmt.setString(6, js.getCity());
		pstmt.setString(7, jobid);
		pstmt.setString(8, js.getjobSeekerId());
		pstmt.executeUpdate();
	
	}

	public void employerRetrieve() throws SQLException {
	
		String empretrive = "select * from batchthree.employee";
		
		pstmt = con.prepareStatement(empretrive);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Employer employer = new Employer();
			employer.setName(rs.getString(1));
			employer.setPhone(rs.getString(2));
			employer.setEmail(rs.getString(3));
			employer.setPassword(rs.getString(4));
			employer.setCompanyName(rs.getString(5));
			employer.setCompanyType(rs.getString(6));
			employer.setJob(rs.getString(7));
			employer.setEmployerId(rs.getString(8));
			HomePage.employers.put(employer.getEmail(), employer);
		
		}
	}

	public void jobseekerRetrieve() throws SQLException {
		
		String jobskretrive = "select * from batchthree.jobseeker";
	
		pstmt = con.prepareStatement(jobskretrive);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			JobSeeker jobseeker = new JobSeeker();
			jobseeker.setName(rs.getString(1));
			jobseeker.setPassword(rs.getString(2));
			jobseeker.setEmail(rs.getString(3));
			jobseeker.setPhone(rs.getString(4));
			jobseeker.setExperience(rs.getString(5));
			jobseeker.setCity(rs.getString(6));
			jobseeker.setjobSeekerId(rs.getString(7));
			HomePage.jobseekers.put(jobseeker.getEmail(), jobseeker);
			
		}
	}

	public void jobRetrieve() throws SQLException {
		String jobretrive = "select * from batchthree.jobs";
	
		pstmt = con.prepareStatement(jobretrive);
		rs = pstmt.executeQuery();
		
		while (rs.next()) 
		{
			Job job = new Job();
			job.setCompanyName(rs.getString(1));
			job.setJobTitle(rs.getString(2));
			job.setLanguage(rs.getString(3));
			job.setEmployment(rs.getString(4));
			job.setJobDescription(rs.getString(5));
			job.setJobLocation(rs.getString(6));
			job.setEmployerId(rs.getString(7));
			job.setJobId(rs.getString(8));
			HomePage.jobs.add(job);
		}
	
	}

	public void jobApplicantRetrieve() throws SQLException {
		String jobapplicantretrive = "select * from batchthree.jobApplicants";
	
		pstmt = con.prepareStatement(jobapplicantretrive);
		rs = pstmt.executeQuery();
		

		while (rs.next()) {
			JobSeeker jobseeker = new JobSeeker();
			jobseeker.setName(rs.getString(1));
			jobseeker.setEmail(rs.getString(2));
			jobseeker.setPassword(rs.getString(3));
			jobseeker.setPhone(rs.getString(4));
			jobseeker.setExperience(rs.getString(5));
			jobseeker.setCity(rs.getString(6));
			jobseeker.setjobSeekerId(rs.getString(8));
			HomePage.applicants.put(rs.getString(7), jobseeker);
		}
	
	}
	
}