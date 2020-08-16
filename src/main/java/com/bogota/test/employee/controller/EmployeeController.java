/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogota.test.employee.controller;


import com.bogota.test.employee.model.Employee;
import com.bogota.test.employee.service.EmployeeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author digital
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@Slf4j
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        log.info("pasa por aca");
        return employeeService.listEmployees();
    }

    @PostMapping("/employee")
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeebyId(@PathVariable("id") String id) {
        Employee cliente = Employee.builder().id(id).build();
        return employeeService.listEmployeeById(cliente);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity deleteCliente(@PathVariable("id") String id) {
        Employee employee = employeeService.listEmployeeById(Employee.builder().id(id).build());
        if (employee != null) {
            employeeService.deleteEmployed(employee);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
