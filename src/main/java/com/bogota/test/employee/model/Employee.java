/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogota.test.employee.model;

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
	private String fullName;
	private String functions;
        private List<String> idEmployee;
}
