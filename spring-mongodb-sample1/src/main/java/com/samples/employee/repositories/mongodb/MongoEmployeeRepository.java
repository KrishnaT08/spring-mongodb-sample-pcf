package com.samples.employee.repositories.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.samples.employee.domain.Employee;

@Repository
public interface MongoEmployeeRepository extends MongoRepository<Employee, String> {
	
}