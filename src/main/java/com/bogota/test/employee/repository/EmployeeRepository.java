/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogota.test.employee.repository;

import com.bogota.test.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author digital
 */
public interface EmployeeRepository extends CrudRepository<Employee, String>{
    
}
