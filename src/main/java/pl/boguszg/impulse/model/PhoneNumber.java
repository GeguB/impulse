package pl.boguszg.impulse.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone_numbers")

public class PhoneNumber {

	@Id
	private int number;
	private String username;
	private String user_email;
	private String assigned;
	
	public PhoneNumber(){
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	@Override
	public String toString() {
		return "PhoneNumber [number=" + number + ", username=" + username + ", user_email=" + user_email + ", assigned="
				+ assigned + "]";
	}
	
	
}
