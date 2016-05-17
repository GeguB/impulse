package pl.boguszg.impulse.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deals")
public class Deal {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	private int user_ID;
	private int plan_ID;
	private String made_time;

	public Deal() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
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

	@Override
	public String toString() {
		return "Deal [id=" + id + ", user_ID=" + user_ID + ", plan_ID=" + plan_ID + ", made_time=" + made_time + "]";
	}


	
	
}
