package com.cognizant.demo.EmployeeDemo.model;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

@Entity
@ApiModel(value = "Details about the  Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "database generated employee id")
    private Long empID;
    
    @Column(name = "Name")
    @ApiModelProperty(notes = "Employee Name")
    private String name;
    
    @Column(name = "Address")
    @ApiModelProperty(notes = "Employee Address")
    private String address;
    
    @Column(name="City")
    @ApiModelProperty(notes = "Employee address city")
    private String city;
    
    @Column(name = "State")
    @ApiModelProperty(notes = "Employee address state")
    private String state;
    
    @Column(name = "Zip")
    @ApiModelProperty(notes = "Employee address zip")
    private String zip;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "PhoneNumber")
    @ApiModelProperty(notes = "Employee address zip")
    private String phoneNumber;
    
    @Column(name = "HiredDate")
    @ApiModelProperty(notes = "Employee hired date")
    private Date hireDate;

    @Column(name="JobTitle")
    @ApiModelProperty(notes = "Employee job title")
    private String jobTitle;

    public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Long getEmpID() {
        return empID;
    }

    public void setEmpID(Long empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "empID=" + empID +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", zip='" + zip + '\'' +
            ", hireDate=" + hireDate +
            ", jobTitle='" + jobTitle + '\'' +
            '}';
    }
}
