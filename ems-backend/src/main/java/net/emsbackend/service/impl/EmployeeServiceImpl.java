package net.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.emsbackend.dto.EmployeeDto;
import net.emsbackend.entity.Employee;
import net.emsbackend.exception.ResourceNotFoundException;
import net.emsbackend.mapper.EmployeeMapper;
import net.emsbackend.repository.EmployeeRepository;
import net.emsbackend.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

 private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(@RequestBody  EmployeeDto employeeDto) {

        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee=employeeRepository.save(employee);


        return EmployeeMapper.mapToEmployeeDTO(saveEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

      Employee employee=  employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(""));



        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees= employeeRepository.findAll();
        return employees.stream().map((employee -> EmployeeMapper.mapToEmployeeDTO(employee))).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto udpateEmployee(Long employeeid, EmployeeDto updateEmployee) {

        Employee employee=employeeRepository.findById(employeeid).orElseThrow(() -> new ResourceNotFoundException(""));

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());


        Employee updateEmpl=employeeRepository.save(employee);


        return EmployeeMapper.mapToEmployeeDTO(updateEmpl);
    }

    @Override
    public void deleteEmployee(Long employeeID) {
     Employee employee= employeeRepository.findById(employeeID).orElseThrow(() -> new ResourceNotFoundException(""));

     employeeRepository.deleteById(employeeID);
    }
}
