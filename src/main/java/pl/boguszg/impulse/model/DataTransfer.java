package pl.boguszg.impulse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="data_transfer")
public class DataTransfer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private int phone_number;
	@Id
	private int size;
	@Id
	private String use_time;
	
	public DataTransfer() {
		
	}
	
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getUse_time() {
		return use_time;
	}
	public void setUse_time(String use_time) {
		this.use_time = use_time;
	}

}
