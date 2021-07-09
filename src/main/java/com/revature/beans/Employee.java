package com.revature.beans;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="employee_id_seq")
	@Column(name="id", insertable=false, updatable=false)
	private int id;
	@Column(name="jobtitle")
	private String jobTitle;
	private String username;
	private String password;

	//constructors
	public Employee() {
		super();
	}
	public Employee(int id, String jobTitle, String username, String password) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.username = username;
		this.password = password;
	}

	//other methods
	@Override
	public int hashCode() {
		return Objects.hash(id, jobTitle, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(jobTitle, other.jobTitle) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "Employee [jobTitle=" + jobTitle + ", username=" + username + ", password=" + password + "]";
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}