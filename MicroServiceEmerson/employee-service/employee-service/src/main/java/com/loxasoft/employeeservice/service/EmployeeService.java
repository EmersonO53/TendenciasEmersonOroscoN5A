package com.loxasoft.employeeservice.service;


import com.loxasoft.employeeservice.dto.DepartamentDto;
import com.loxasoft.employeeservice.dto.ResponseDto;
import com.loxasoft.employeeservice.entity.Employee;
import com.loxasoft.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public ResponseDto getEmployeeById(Integer id) {
        ResponseDto responseDto = new ResponseDto();
        Employee employee = new Employee();
        employee = employeeRepository.findById(id).get();

        ResponseEntity<DepartamentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departaments/"+employee.getDepartamentId(),
                DepartamentDto.class);

        DepartamentDto departamentDto = responseEntity.getBody();
        responseDto.setEmployee(employee);
        responseDto.setDepartamentDto(departamentDto);

        return responseDto;

    }
}

