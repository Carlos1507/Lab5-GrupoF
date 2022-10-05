package com.pucp.lab5gtics.repository;

import com.pucp.lab5gtics.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Completar
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
     @Query(value = "select * from employees where (first_name like %?1%) or (last_name like %?1%) order by first_name ASC ", nativeQuery = true)
     List<Employee> filtrarEmpleados(String caracteres);
}
