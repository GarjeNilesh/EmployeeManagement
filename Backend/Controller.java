package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Employee;
import com.crud.model.Worker;
import com.crud.service.ServiceImplementation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {

    @Autowired
    ServiceImplementation servImp;

      @PostMapping("/saveEmployee")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee emp) {
        return new ResponseEntity<>(servImp.saveEmployee(emp), HttpStatus.OK);
    }

    @PostMapping("/saveWorker")
    public ResponseEntity<?> saveWorker(@RequestBody Worker worker) {
        return new ResponseEntity<>(servImp.saveWorker(worker), HttpStatus.OK);
    }

    @GetMapping("/workers")
    public ResponseEntity<List<Worker>> getAllWorkers() {
        List<Worker> workers = servImp.findAllWorkers();
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @DeleteMapping("/workers/{id}")
    public ResponseEntity<?> deleteWorker(@PathVariable Integer id) {
        String result = servImp.deleteWorkerById(id);
        if (result.equals("Worker deleted successfully")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody Employee emp) {
        // Check if the email and password match
        boolean isValidUser = servImp.verifyEmployee(emp.getEmail(), emp.getPassword());
        
        if (isValidUser) {
            return ResponseEntity.ok().body("Login Successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        }
    }
}

