/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogota.test.employee.controller;

import com.bogota.test.employee.model.Employee;
import com.bogota.test.employee.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@Slf4j
public class EmployeeControllerTest {
    
    @InjectMocks
    EmployeeController employeeController;
    
    @Mock
    EmployeeService employeeService;
    
    
    @Test
    public void itShouldReturnWith200ResponseGetEmployeeAll(){
        List<String> idEmployee = new ArrayList<>();
        idEmployee.add("1");
        List<Employee> list = new ArrayList<>();
        Employee em = Employee.builder().id("1").fullName("oscar").functions("pum").idEmployee(idEmployee).build();
        list.add(em);
        Mockito.when(employeeService.listEmployees()).thenReturn(list);
        List<Employee> resp =  employeeController.getAllEmployee();
        Assert.assertEquals(resp, list);
    }
    
    @Test
    public void itShouldReturnWith200ResponseGetEmployeeById(){
        List<String> idEmployee = new ArrayList<>();
        idEmployee.add("1");
        Employee em = Employee.builder().id("1").build();
        Mockito.when(employeeService.listEmployeeById(em)).thenReturn(em);
        Employee resp =  employeeController.getEmployeebyId("1");
        Assert.assertEquals(resp, em);
    }
    
    @Test
    public void itShouldReturnWith201ResponsePostEmployee(){
        List<String> idEmployee = new ArrayList<>();
        idEmployee.add("1");
        Employee em = Employee.builder().id("1").fullName("oscar").functions("pum").idEmployee(idEmployee).build();
        
        ResponseEntity<String> resp = employeeController.addEmployee(em);
        
        Assert.assertEquals(resp.getStatusCode(), HttpStatus.CREATED);
    }
    
    

}
