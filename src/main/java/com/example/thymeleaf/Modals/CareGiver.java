package com.example.thymeleaf.Modals;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="care_giver")
public class CareGiver {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int care_giver_id;
	
	@Column(nullable=false,length=50)
	private String email_id;
	@Column(nullable=false, length=50)
	private String password;
	
	@Column(nullable=false,length=50)
	private String first_name;
	@Column(nullable=false,length=50)
	private String last_name;
	@Column(nullable=false)
	private int age;
	@Column(nullable=false,length=100)
	private String providing_service;
	@Column(nullable=false)
	private double rating;
	@Column(nullable=false,length=50)
	private int no_of_consultants;
	@Column(nullable=true)
	private Integer care_recep_id;
	public int getCare_giver_id() {
		return care_giver_id;
	}
	public void setCare_giver_id(int care_giver_id) {
		this.care_giver_id = care_giver_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProviding_service() {
		return providing_service;
	}
	public void setProviding_service(String providing_service) {
		this.providing_service = providing_service;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getNo_of_consultants() {
		return no_of_consultants;
	}
	public void setNo_of_consultants(int no_of_consultants) {
		this.no_of_consultants = no_of_consultants;
	}
	public int getCare_recep_id() {
		return care_recep_id;
	}
	public void setCare_giver_id(Integer care_recep_id) {
		if(care_recep_id==null) {
			this.care_recep_id=-1;
		}
		else {
			this.care_recep_id=care_recep_id;
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
