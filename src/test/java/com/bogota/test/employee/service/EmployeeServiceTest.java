/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogota.test.employee.service;

import com.bogtoa.test.employee.service.EmployeeService;
import com.bogota.test.employee.model.Employee;
import com.bogota.test.employee.repository.EmployeeRepository;
import com.bogota.test.employee.service.impl.EmployeeServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author oscarivanrincontenjo
 */
@RunWith(SpringRunner.class)
@ExtendWith (MockitoExtension.class) 
public class EmployeeServiceTest {
    @InjectMocks
    final EmployeeService employeeService = new EmployeeServiceImpl();
    
    @Mock
    private EmployeeRepository employeeRepository;
    

    
    private Employee em;
    private List<Employee> list;
    
    
    @BeforeEach
    void setUp(){   
    }
    
    @Test
    public void listEmployeesTest(){
        list = new ArrayList<>();
        em  = Employee.builder().id(123).firstName("oscar").lastName("rincon").age(32).phoneNumber("33121212").numberAccount("32322323").build();  
        list.add(em);
        Mockito.when(employeeRepository.findAll()).thenReturn(list);
        
        List<Employee> expect = employeeService.listEmployees();
        
        Assert.assertEquals(list,expect);
           
        
    }
    
    @Test
    public void listEmployeebyIdTest() {
        Employee idEmployee = Employee.builder().id(123).build();
        em  = Employee.builder().id(123).firstName("oscar").lastName("rincon").age(32).phoneNumber("33121212").numberAccount("32322323").build();
        Mockito.when(employeeRepository.findById(idEmployee.getId())).thenReturn(Optional.of(em));
        
        Employee expect = employeeService.listEmployeeById(idEmployee);
        
        Assert.assertEquals(expect, em);
    }
    
    @Test
    public void insertEmployeeTest() {
        em  = Employee.builder().id(123).firstName("oscar").lastName("rincon").age(32).phoneNumber("33121212").numberAccount("32322323").build();
        Employee idEmployee = Employee.builder().id(123).build();
        
       employeeService.insertEmployee(em);
       Mockito.verify(employeeRepository, Mockito.times(1)).save(em);
        
       Mockito.verifyNoMoreInteractions(employeeRepository);
        
    }
    
    @Test
    public void deleteEmployedTest() {
        em  = Employee.builder().id(123).firstName("oscar").lastName("rincon").age(32).phoneNumber("33121212").numberAccount("32322323").build();
        
       employeeService.deleteEmployed(em);
       Mockito.verify(employeeRepository, Mockito.times(1)).delete(em);
        
       Mockito.verifyNoMoreInteractions(employeeRepository);
        
    }
    
    
    
    

}
