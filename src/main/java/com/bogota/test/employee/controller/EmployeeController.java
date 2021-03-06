/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogota.test.employee.controller;


import com.bogota.test.employee.model.Employee;
import com.bogtoa.test.employee.service.EmployeeService;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author digital
 */
//@CrossOrigin(origins = "*")
@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    @Cacheable(value = "employees")
    public List<Employee> getAllEmployee()throws Exception {
        return employeeService.listEmployees();
    }

    @PostMapping(value = "/employee")
    @ResponseBody
    public ResponseEntity addEmployee( @RequestBody Employee employee) throws Exception{
        employeeService.insertEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/employee/{id}")
    @Cacheable( value = "employees", key="#id")
    public Employee getEmployeebyId(@PathVariable("id") int id) throws Exception {
        Employee cliente = Employee.builder().id(id).build();
        return employeeService.listEmployeeById(cliente);
    }

    @DeleteMapping("/employee/{id}")
    @CacheEvict( value = "employees", allEntries = true)
    public ResponseEntity deleteCliente(@PathVariable("id") int id) {
        Employee employee = employeeService.listEmployeeById(Employee.builder().id(id).build());
        if (employee != null) {
            employeeService.deleteEmployed(employee);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
