package com.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    // You can add methods here as needed, e.g., to find by email
}
