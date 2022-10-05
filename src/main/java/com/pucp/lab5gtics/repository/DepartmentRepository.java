package com.pucp.lab5gtics.repository;

import com.pucp.lab5gtics.entity.Department;
import com.pucp.lab5gtics.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Completar
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
