package com.spring.planview.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_registration")

public class UserRegistration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	private String Emloyeeemail;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmloyeeemail() {
		return Emloyeeemail;
	}
	public void setEmloyeeemail(String emloyeeemail) {
		Emloyeeemail = emloyeeemail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
	



}
