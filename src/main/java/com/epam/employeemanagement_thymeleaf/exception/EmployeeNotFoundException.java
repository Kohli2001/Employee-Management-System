package com.epam.employeemanagement_thymeleaf.exception;

import com.epam.employeemanagement_thymeleaf.model.Employee;

public class EmployeeNotFoundException extends  RuntimeException{

    public EmployeeNotFoundException(String message){
        super(message);
    }


}
