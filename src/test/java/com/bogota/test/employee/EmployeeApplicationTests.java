package com.bogota.test.employee;

import com.bogota.test.employee.EmployeeApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class EmployeeApplicationTests {

	@Test
	void contextLoads() {
             EmployeeApplication.main(new String[] {});
	}
        

}
