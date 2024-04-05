package net.emsbackend.service;

import net.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto udpateEmployee(Long employeeid, EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeID);

}
