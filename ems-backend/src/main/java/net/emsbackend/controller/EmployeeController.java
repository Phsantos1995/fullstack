package net.emsbackend.controller;


import lombok.AllArgsConstructor;
import net.emsbackend.dto.EmployeeDto;
import net.emsbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")


public class EmployeeController
{
    private EmployeeService employeeService;

   @PostMapping
    public ResponseEntity<EmployeeDto> createEmplotee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public  ResponseEntity<EmployeeDto> getEmploteebyID( @PathVariable("id") Long ID){
       EmployeeDto employeeDto=employeeService.getEmployeeById(ID);
      return ResponseEntity.ok(employeeDto);
   }


    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getAllEmployee(){
       List<EmployeeDto> employees=employeeService.getAllEmployees();

       return ResponseEntity.ok(employees);
    }


@PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeId,  @RequestBody EmployeeDto employeeDto ){
    EmployeeDto employeeDto1=employeeService.udpateEmployee(employeId,employeeDto);
    return ResponseEntity.ok(employeeDto1);
    }


    @DeleteMapping("{id}")
    public  ResponseEntity<String>deleteEmployee(@PathVariable("id") Long employeeID){
       employeeService.deleteEmployee(employeeID);

       return ResponseEntity.ok("Employee deleted sucess");
    }

}
