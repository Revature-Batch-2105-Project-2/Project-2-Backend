package com.revature.beans;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="partlookup")
public class PartLookUp {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="partlookup_id_seq")
	@Column(name="id", insertable=false, updatable=false)
	private int id;
	private String name;
	private int price;
	private float time;
	//constructors
	public PartLookUp(int id, String name, int price, float time) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.time = time;
	}
	public PartLookUp() {
		super();
	}
	
	//other methods
	@Override
	public int hashCode() {
		return Objects.hash(id, name, price, time);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartLookUp other = (PartLookUp) obj;
		return id == other.id && Objects.equals(name, other.name)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Float.floatToIntBits(time) == Float.floatToIntBits(other.time);
	}
	@Override
	public String toString() {
		return "PartLookUp [name=" + name + ", price=" + price + ", time=" + time + "]";
	}
	
	//getter and setters
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}
}