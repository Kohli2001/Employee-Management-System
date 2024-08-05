package com.epam.employeemanagement_thymeleaf.service;

import com.epam.employeemanagement_thymeleaf.exception.EmployeeNotFoundException;
import com.epam.employeemanagement_thymeleaf.model.Employee;
import com.epam.employeemanagement_thymeleaf.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements  EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
         employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        isValid(id);
         employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        isValid(id);
        return employeeRepository.findById(id).get();
    }
    @Override
    public void deleteEmployeeById(int id) {
        isValid(id);
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        if(employeeRepository.findAll().isEmpty()){
            throw new EmployeeNotFoundException("No Employee is Present!");
        }
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        if(employeeRepository.findByName(name).isEmpty()){
            throw new EmployeeNotFoundException("Employee not found with name: "+name);
        }
        return employeeRepository.findByName(name);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        if(employeeRepository.findByName(email).isEmpty()){
            throw new EmployeeNotFoundException("Employee not found with email: "+email);
        }
        return employeeRepository.findByName(email).get(0);
    }
    private void isValid(int id){
        if(employeeRepository.findById(id).isEmpty()){
            throw new EmployeeNotFoundException("Invalid Employee Id");
        }
    }

}
