package com.revature.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Vehicle;

@Repository
public interface IVehicleRepo extends CrudRepository<Vehicle, Integer>{
	List<Vehicle> findByCustomer_Id(int id);
	List<Vehicle> findByVin(int vin);
}
