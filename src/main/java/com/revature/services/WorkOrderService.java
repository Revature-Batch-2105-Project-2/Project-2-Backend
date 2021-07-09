package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.WorkOrder;
import com.revature.repo.IWorkOrderRepo;

@Component
public class WorkOrderService implements IWorkOrderService {
	private IWorkOrderRepo repo;
	
	@Autowired
	public WorkOrderService(IWorkOrderRepo repo) {
		this.repo = repo;
	}

	@Override
	public WorkOrder get(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<WorkOrder> getAll() {
		return (List<WorkOrder>) this.repo.findAll();
	}

	@Override
	public WorkOrder add(WorkOrder wo) {
		return this.repo.save(wo);
	}

	@Override
	public WorkOrder update(WorkOrder wo) {
		return this.repo.save(wo);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}
}
