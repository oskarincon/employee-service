/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogtoa.test.employee.service;

import com.bogota.test.employee.model.Employee;
import java.util.List;

/**
 *
 * @author digital
 */
public interface EmployeeService {
    
    public List<Employee> listEmployees();
    
    public Employee listEmployeeById(Employee Employee);
    
    public void insertEmployee(Employee Employee);
    
    public void deleteEmployed(Employee Employee);
}
