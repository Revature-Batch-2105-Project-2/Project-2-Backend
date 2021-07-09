package com.revature.beans;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="vehicle_id_seq")
	@Column(name="id", insertable=false, updatable=false)
	private int id;
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	private int vin;
	private String make;
	private String model;
	private int year;
	private int mileage;
	//constructors
	public Vehicle(int id, Customer customerId, int vin, String make, String model, int year, int mileage) {
		super();
		this.id = id;
		this.customer = customerId;
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
	}
	public Vehicle() {
		super();
	}
	
	//other methods
	@Override
	public int hashCode() {
		return Objects.hash(customer, id, make, mileage, model, vin, year);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return customer == other.customer && id == other.id && Objects.equals(make, other.make)
				&& mileage == other.mileage && Objects.equals(model, other.model) && vin == other.vin
				&& year == other.year;
	}
	@Override
	public String toString() {
		return "Vehicle [customerId=" + customer + ", vin=" + vin + ", make=" + make + ", model=" + model + ", year="
				+ year + ", mileage=" + mileage + "]";
	}
	
	//getter and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomerId() {
		return customer;
	}
	public void setCustomerId(Customer customerId) {
		this.customer = customerId;
	}
	public int getVin() {
		return vin;
	}
	public void setVin(int vin) {
		this.vin = vin;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
}