package pl.boguszg.impulse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {


	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Id
	@Column(name="username")
	private String username;
	private String email;
	private double account;
	private int minutes_left;
	private int texts_left;
	private int kb_left;
	private int enabled;
	private int phone_number;
	private String password;
	private String roles_role;
			
	public User(){
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

	public int getMinutes_left() {
		return minutes_left;
	}


	public void setMinutes_left(int minutes_left) {
		this.minutes_left = minutes_left;
	}


	public int getTexts_left() {
		return texts_left;
	}


	public void setTexts_left(int texts_left) {
		this.texts_left = texts_left;
	}


	public int getKb_left() {
		return kb_left;
	}


	public void setKb_left(int kb_left) {
		this.kb_left = kb_left;
	}


	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRoles_role() {
		return roles_role;
	}


	public void setRoles_role(String roles_role) {
		this.roles_role = roles_role;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", account=" + account
				+ ", minutes_left=" + minutes_left + ", texts_left=" + texts_left + ", kb_left=" + kb_left
				+ ", enabled=" + enabled + ", password=" + password + ", roles_role=" + roles_role + "]";
	}

}
