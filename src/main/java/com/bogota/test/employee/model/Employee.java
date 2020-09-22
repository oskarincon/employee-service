/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogota.test.employee.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;


/**
 *
 * @author digital
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table( name = "employees")
public class Employee implements Serializable{
    	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
        
        @Column(name = "number_account", nullable = false)
	private String numberAccount;
        
}
