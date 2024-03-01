package com.example.thymeleaf.Modals;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="care_recipient")
public class CareRecipient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false,length=50)
	private String fname;
	@Column(nullable=false,length=50)
	private String lname;
	@Column(nullable=false,length=50)
	private String username;
	@Column(nullable=false,length=50)
	private String password;
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
	@Column(nullable=false)
	private int age;
	@Column(nullable=false,length=50)
	private String type_of_service;
	@Column(nullable=false,length=10)
	private String contact;
	@Column(nullable=true)
	private Integer care_giver_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getType_of_service() {
		return type_of_service;
	}
	public void setType_of_service(String type_of_service) {
		this.type_of_service = type_of_service;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getCare_giver_id() {
		return care_giver_id;
	}
	public void setCare_giver_id(Integer care_giver_id) {
		if(care_giver_id==null) {
			this.care_giver_id=-1;
		}
		else {
			this.care_giver_id=care_giver_id;
		}
	}
	
	
}
