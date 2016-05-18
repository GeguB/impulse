package pl.boguszg.impulse.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "deals")
public class Deal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	private int user_ID;
	private int plan_ID;
	@Basic(optional = false)
	@Column(name = "made_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date made_time;

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


	public Date getMade_time() {
		return made_time;
	}

	public void setMade_time(Date made_time) {
		this.made_time = made_time;
	}

	@Override
	public String toString() {
		return "Deal [id=" + id + ", user_ID=" + user_ID + ", plan_ID=" + plan_ID + "]";
	}


	
	
}
