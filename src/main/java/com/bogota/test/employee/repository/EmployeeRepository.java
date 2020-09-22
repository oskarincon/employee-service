/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogota.test.employee.repository;

import com.bogota.test.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digital
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
    
}
