package com.revature.beans;

import java.sql.Date;

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
	@Column(name="startdate")
	private Date date;
	private float cost;
	private boolean complete;
	
	//constructors
	public WorkOrder(int id, Vehicle vehicleId, Employee employeeId, String description, Date date, float cost, boolean complete) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (complete ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(cost);
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + id;
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
		return result;
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
		if (complete != other.complete)
			return false;
		if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id != other.id)
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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