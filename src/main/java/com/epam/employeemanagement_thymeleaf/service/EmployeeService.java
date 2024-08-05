package com.epam.employeemanagement_thymeleaf.service;

import com.epam.employeemanagement_thymeleaf.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    void saveEmployee(Employee employee);
    void updateEmployee(int id ,Employee employee);
    Employee getEmployeeById(int id);
    void deleteEmployeeById(int id);
    List<Employee> getAllEmployee();
    List<Employee> getEmployeeByName(String name);
    Employee getEmployeeByEmail(String email);
}
