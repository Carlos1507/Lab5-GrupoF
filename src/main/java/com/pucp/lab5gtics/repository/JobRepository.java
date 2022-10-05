package com.pucp.lab5gtics.repository;

import com.pucp.lab5gtics.entity.Employee;
import com.pucp.lab5gtics.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Completar
public interface JobRepository extends JpaRepository<Job, Integer> {
}
