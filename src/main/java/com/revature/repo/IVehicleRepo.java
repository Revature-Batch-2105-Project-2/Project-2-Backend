package com.revature.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Vehicle;

@Repository
public interface IVehicleRepo extends CrudRepository<Vehicle, Integer>{

}
