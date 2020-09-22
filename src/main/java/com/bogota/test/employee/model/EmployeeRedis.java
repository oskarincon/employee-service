/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogota.test.employee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author oscarivanrincontenjo
 */
@AllArgsConstructor
@Data
@Builder
@RedisHash("Employee")
public class EmployeeRedis {
        	private static final long serialVersionUID = 1L;
	private @NonNull String id;
	private String firstName;
	private String lastName;
	private int age;
	private String phoneNumber;
	private String numberAccount;
}
