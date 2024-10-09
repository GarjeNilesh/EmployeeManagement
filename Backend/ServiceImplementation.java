package com.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.model.Employee;
import com.crud.model.Worker;
import com.crud.repo.EmployeeRepository;
import com.crud.repo.WorkerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    WorkerRepository workerRepo;

    
    @Override
    public Employee saveEmployee(Employee emp) {
        // Hash the password before saving the employee
         return empRepo.save(emp);
    }

    @Override
    public Worker saveWorker(Worker worker) {
        return workerRepo.save(worker);
    }

    public List<Worker> findAllWorkers() {
        return workerRepo.findAll();
    }

    @Override
    public String deleteWorkerById(Integer id) {
        Optional<Worker> worker = workerRepo.findById(id);
        if (worker.isPresent()) {
            workerRepo.deleteById(id);
            return "Worker deleted successfully";
        } else {
            return "Worker not found";
        }
    }

    public boolean verifyEmployee(String email, String password) {
        List<Employee> employees = empRepo.findEmployeesByEmail(email);
        
        if (employees.isEmpty()) {
            return false; // Employee not found
        }
        
        // Assuming you want to verify against the first found employee
        Employee employee = employees.get(0);
        return password.equals(employee.getPassword());
    }
    
    

}
