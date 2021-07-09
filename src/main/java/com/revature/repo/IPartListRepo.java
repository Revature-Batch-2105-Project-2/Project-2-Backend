package com.revature.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.PartList;

@Repository
public interface IPartListRepo extends CrudRepository<PartList, Integer>{

}
