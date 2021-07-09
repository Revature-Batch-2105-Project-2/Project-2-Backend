package com.revature.services;

import java.util.List;

import com.revature.beans.WorkOrder;

public interface IWorkOrderService {
	public WorkOrder get(int id);
	public List<WorkOrder> getAll();
	public WorkOrder add(WorkOrder wo);
	public WorkOrder update(WorkOrder wo);
	public void delete(int id);
}
