package com.epam.employeemanagement_thymeleaf.dto;

import lombok.Builder;

@Builder
public record ExceptionResponse(String httpStatus, String message, String timestamp) {
}
