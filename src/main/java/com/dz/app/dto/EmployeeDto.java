package com.dz.app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeDto implements Serializable {


	private Long eid;
	private String firstName;
	private String lastName;
	private String gender;
	private String status;
	private BasePropertiesDto baseProperties;
	private Date birthDate;
	private Double salary;
	
	public EmployeeDto() {
		super();
	}
	
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BasePropertiesDto getBaseProperties() {
		return baseProperties;
	}
	public void setBaseProperties(BasePropertiesDto baseProperties) {
		this.baseProperties = baseProperties;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDto [eid=" + eid + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", status=" + status + ", baseProperties=" + baseProperties + ", birthDate=" + birthDate + ", salary="
				+ salary + "]";
	}
	
	
}
