package com.techleads.app.repository;

import java.util.Map;

import com.techleads.app.model.Employee;

public interface EmployeeRepository {
	void save(Employee student);
	void update(Employee student);
	Employee findById(Integer id);
	Map<Integer,Employee> findAll();
	void deleteById(Integer id);

}
