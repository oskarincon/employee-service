/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.test.employee.model;

import java.util.List;
import lombok.*;
import lombok.NonNull;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author digital
 */

@AllArgsConstructor
@Data
@Builder
@RedisHash("Employee")
public class Employee {
    	private static final long serialVersionUID = 1L;
	private @NonNull String id;
	private String firstName;
	private String lastName;
	private int age;
	private String phoneNumber;
	private String numberAccount;
        
}
