package net.emsbackend.mapper;

import net.emsbackend.dto.EmployeeDto;
import net.emsbackend.entity.Employee;

public class EmployeeMapper {


    public  static EmployeeDto mapToEmployeeDTO(Employee employee){
        return  new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public  static Employee mapToEmployee(EmployeeDto employeeDto){
        return  new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }



}
