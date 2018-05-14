package com.mss.demo.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

	@XmlElement
	String firstName;
	
	@XmlElement
	String lastName;
	
	@XmlElement
	String dept;
	
	@XmlElement
	int empId;

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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "TrainSchedule [firstName=" + firstName + ", lastName=" + lastName + ", dept=" + dept + ", empId="
				+ empId + "]";
	}

	public Employee(String firstName, String lastName, String dept, int empId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
		this.empId = empId;
	}
	
	public Employee() {
		super();
	}
}
