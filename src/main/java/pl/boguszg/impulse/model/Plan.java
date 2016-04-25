package pl.boguszg.impulse.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plans")
public class Plan {

	@Id
	private int id;
	private String name;
	private String type;
	private float price;
	int value;
	private String created;

	public Plan() {

	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated() {
		DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		String sdt = df.format(new Date());
		this.created = sdt;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", value=" + value
				+ ", created=" + created + "]";
	}
	
}
