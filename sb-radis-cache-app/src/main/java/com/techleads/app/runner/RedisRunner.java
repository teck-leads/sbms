package com.techleads.app.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.model.Employee;
import com.techleads.app.repository.EmployeeRepository;
@Component
public class RedisRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		employeeRepository.save(new Employee(101, "madhav", "IT, Digital"));
		employeeRepository.save(new Employee(102, "Dill", "IOT, AI"));
		employeeRepository.save(new Employee(103, "teja", "DB admin"));
		employeeRepository.save(new Employee(104, "ram", "Audit"));
		
		Map<Integer, Employee> findAll = employeeRepository.findAll();
		findAll.forEach((k,v)->{System.out.println(k+" "+v);});
	}

}
