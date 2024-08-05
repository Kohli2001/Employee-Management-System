package com.epam.employeemanagement_thymeleaf.exception;

import com.epam.employeemanagement_thymeleaf.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(Model model,EmployeeNotFoundException exception) {
        ExceptionResponse response = ExceptionResponse.builder()
                .message(exception.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND.name())
                .timestamp(new Date().toString()).build();
        model.addAttribute("exceptions",response);
        return "exception";
    }

}
