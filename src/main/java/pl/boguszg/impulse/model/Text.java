package pl.boguszg.impulse.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="texts")
public class Text implements Serializable{
	
	@Id
	private int phone_number;
	@Id
	private int sent_to;
	@Id
	private String sent_time;
	
	public Text(){
		
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public int getSent_to() {
		return sent_to;
	}

	public void setSent_to(int sent_to) {
		this.sent_to = sent_to;
	}

	public String getSent_time() {
		return sent_time;
	}

	public void setSent_time(String sent_time) {
		DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		String sdt = df.format(new Date());
		this.sent_time = sdt;
	}
	
	@Override
	public String toString() {
		return "Text [phone_number=" + phone_number + ", sent_to=" + sent_to + ", sent_time=" + sent_time + "]";
	}

}
