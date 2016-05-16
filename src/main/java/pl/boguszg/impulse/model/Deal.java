package pl.boguszg.impulse.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deals")

public class Deal {

	@Id
	private int id;
	private int user_ID;
	private int plan_ID;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_Id() {
		return user_ID;
	}
	public void setUser_Id(int user_Id) {
		this.user_ID = user_Id;
	}
	public int getPlan_ID() {
		return plan_ID;
	}
	public void setPlan_ID(int plan_ID) {
		this.plan_ID = plan_ID;
	}
	public String getMade_time() {
		return made_time;
	}
	public void setMade_time(String made_time) {
		DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		String sdt = df.format(new Date());
		this.made_time = sdt;
	}
	private String made_time;

	@Override
	public String toString() {
		return "Deal [id=" + id + ", user_ID=" + user_ID + ", plan_ID=" + plan_ID + ", made_time=" + made_time
				+ "]";
	}
	
}
