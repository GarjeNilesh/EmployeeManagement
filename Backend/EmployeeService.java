package com.crud.service;

import com.crud.model.Employee;
import com.crud.model.Worker;
import com.crud.repo.EmployeeRepository;

public interface EmployeeService {
   
	
	public Employee saveEmployee(Employee emp);
	
	public boolean verifyEmployee(String email, String password);
	
	public Worker saveWorker(Worker worker);
	
	public String deleteWorkerById(Integer id);
	

	
} 
