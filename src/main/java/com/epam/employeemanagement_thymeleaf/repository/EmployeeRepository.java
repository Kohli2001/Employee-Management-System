package com.epam.employeemanagement_thymeleaf.repository;

import com.epam.employeemanagement_thymeleaf.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmail(String email);
    List<Employee> findByName(String name);
}
