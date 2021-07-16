package com.revature.services;

import java.util.List;

import com.revature.beans.Vehicle;

public interface IVehicleService {
	public Vehicle get(int id);
	public List<Vehicle> getByCustomerId(int id);
	public List<Vehicle> getAll();
	public List<Vehicle> getByVin(int vin);
	public Vehicle add(Vehicle v);
	public Vehicle update(Vehicle v);
	public void delete(int id);
}
