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
@Table(name="partlist")
public class PartList {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="partlist_id_seq")
	@Column(name="id", insertable=false, updatable=false)
	private int id;
	@ManyToOne
	@JoinColumn(name="partid")
	private PartLookUp part;
	@ManyToOne
	@JoinColumn(name="orderid")
	private WorkOrder order;
	//constructors
	public PartList(int id, PartLookUp partId, WorkOrder orderId) {
		super();
		this.id = id;
		this.part = partId;
		this.order = orderId;
	}
	public PartList() {
		super();
	}
	
	//other methods
	@Override
	public int hashCode() {
		return Objects.hash(id, order, part);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartList other = (PartList) obj;
		return id == other.id && order == other.order && part == other.part;
	}
	@Override
	public String toString() {
		return "PartList [partId=" + part + ", orderId=" + order + "]";
	}
	
	//getter and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PartLookUp getPart() {
		return part;
	}
	public void setPart(PartLookUp part) {
		this.part = part;
	}
	public WorkOrder getOrder() {
		return order;
	}
	public void setOrder(WorkOrder order) {
		this.order = order;
	}
}