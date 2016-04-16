package pl.boguszg.impulse.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calls")
public class Call implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private int phone_number;
	@Id
	private int calling_to;
	@Id
	private int duration;
	@Id
	private String end_time;
	
	public Call(){
		
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public int getCalling_to() {
		return calling_to;
	}

	public void setCalling_to(int calling_to) {
		this.calling_to = calling_to;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		String sdt = df.format(new Date());
		this.end_time = sdt;
	}

	@Override
	public String toString() {
		return "Call [phone_number=" + phone_number + ", calling_to=" + calling_to + ", duration=" + duration
				+ ", datetime=" + end_time + "]";
	}
	
	

}
