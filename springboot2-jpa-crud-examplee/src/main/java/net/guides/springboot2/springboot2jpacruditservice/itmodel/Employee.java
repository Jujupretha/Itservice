package net.guides.springboot2.springboot2jpacruditservice.itmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itservice")
public class Employee {

	private long id;
	private String empname;
	private String empid;
	private String emailid;
	private String itteam;
	private String description;
	
	public Employee() {
		
	}
	
	
	
	public Employee(long id, String empname, String empid, String emailid, String itteam, String description) {
		super();
		this.id = id;
		this.empname = empname;
		this.empid = empid;
		this.emailid = emailid;
		this.itteam = itteam;
		this.description = description;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}



	public String getEmpid() {
		return empid;
	}



	public void setEmpid(String empid) {
		this.empid = empid;
	}



	public String getEmailid() {
		return emailid;
	}



	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}



	public String getItteam() {
		return itteam;
	}



	public void setItteam(String itteam) {
		this.itteam = itteam;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + ", empid=" + empid + ", emailid=" + emailid + ", itteam="
				+ itteam + ", description=" + description + "]";
	}
	
}
