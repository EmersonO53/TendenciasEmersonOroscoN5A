package com.loxasoft.employeeservice.dto;

import com.loxasoft.employeeservice.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private Employee employee;
    private DepartamentDto departamentDto;
}
