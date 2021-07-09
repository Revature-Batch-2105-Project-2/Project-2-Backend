package com.revature.beans;

import java.text.SimpleDateFormat;
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
@Table(name="workorder")
public class WorkOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="workorder_id_seq")
	@Column(name="id", insertable=false, updatable=false)
	private int id;
	@ManyToOne
	@JoinColumn(name="vehicleid")
	private Vehicle vehicle;
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Employee employee;
	private String description;
	private SimpleDateFormat date;
	private float cost;
	private boolean complete;
	
	//constructors
	public WorkOrder(int id, Vehicle vehicleId, Employee employeeId, String description, SimpleDateFormat date, float cost, boolean complete) {
		super();
		this.id = id;
		this.vehicle = vehicleId;
		this.employee = employeeId;
		this.description = description;
		this.date = date;
		this.cost=cost;
		this.complete=complete;
	}
	public WorkOrder() {
		super();
	}
	//other methods
	@Override
	public int hashCode() {
		return Objects.hash(date, description, employee, id, vehicle, cost,complete);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkOrder other = (WorkOrder) obj;
		return Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& employee == other.employee && id == other.id && vehicle == other.vehicle;
	}
	@Override
	public String toString() {
		return "WorkOrder [vehicleId=" + vehicle + ", employeeId=" + employee + ", description=" + description
				+ ", date=" + date +", cost="+cost+", complete="+complete+ "]";
	}
	
	//getter and setters

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Vehicle getVehicleId() {
		return vehicle;
	}
	public void setVehicleId(Vehicle vehicleId) {
		this.vehicle = vehicleId;
	}
	public Employee getEmployeeId() {
		return employee;
	}
	public void setEmployeeId(Employee employeeId) {
		this.employee = employeeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	//if replaceing date with string comment this out
	public SimpleDateFormat getDate() {
		return date;
	}
	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}
	/*getter and setter for date string
	 * public String getDate(){
	 * return date;
	 * }
	 * public void setDate(String date){
	 * this.date=date;
	 * }
	 */
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
}