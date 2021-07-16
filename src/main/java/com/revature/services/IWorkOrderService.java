package com.revature.services;

import java.util.List;

import com.revature.beans.WorkOrder;

public interface IWorkOrderService {
	public WorkOrder get(int id);
	public List<WorkOrder> getAll();
	public List<WorkOrder> getByVehicleId(int id);
	public List<WorkOrder> getByVehicleVin(int vin);
	public List<WorkOrder> getByCustomerId(int id);
	public List<WorkOrder> getByCustomerEmail(String email);
	public List<WorkOrder> getByCustomerPhoneNumber(String phone);
	public List<WorkOrder> getByCustomerName(String firstName, String lastName);
	public List<WorkOrder> getCompletedOrders();
	public List<WorkOrder> getPendingOrders();
	public WorkOrder add(WorkOrder wo);
	public WorkOrder update(WorkOrder wo);
	public void delete(int id);
}
