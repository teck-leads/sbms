package com.techleads.app.repository;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.techleads.app.model.Employee;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private final String KEY="EMPOYEE";
	@Resource(name = "redisTemplate")
	private HashOperations<String, Integer, Employee> hashOperations;

	@Override
	public void save(Employee employee) {
		hashOperations.putIfAbsent(KEY, employee.getId(), employee);
		
	}

	@Override
	public void update(Employee employee) {
		hashOperations.putIfAbsent(KEY, employee.getId(), employee);
		
	}

	@Override
	public Employee findById(Integer id) {
		Employee student = hashOperations.get(KEY, id);
		return student;
	}

	@Override
	public Map<Integer, Employee> findAll() {
		Map<Integer, Employee> entries = hashOperations.entries(KEY);
		return entries;
	}

	@Override
	public void deleteById(Integer id) {
		hashOperations.delete(KEY, id);
		
	}
	
	

}

