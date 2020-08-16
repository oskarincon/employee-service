/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogota.test.employee.service.impl;

import com.bogota.test.employee.model.Employee;
import com.bogota.test.employee.repository.EmployeeRepository;
import com.bogota.test.employee.service.EmployeeService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digital
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee listEmployeeById(Employee Employee) {
        
        return employeeRepository.findById(Employee.getId()).orElse(null);
    }

    @Override
    public void insertEmployee(Employee Employee) {
        employeeRepository.save(Employee);
    }

    @Override
    public void deleteEmployed(Employee Employee) {
        employeeRepository.delete(Employee);
    }


    
}
