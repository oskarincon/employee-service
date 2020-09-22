/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogota.test.employee.controller;


import com.bogota.test.employee.controller.EmployeeController;
import com.bogota.test.employee.model.Employee;
import com.bogtoa.test.employee.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
@WithMockUser
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;
        
    private List<Employee> list;
    
    @BeforeEach
    void setup() {
        
    }
    

    @Test
    public void getEmployeesTest() throws Exception {
        list = new ArrayList<>();
        Employee em = Employee.builder().id("123").firstName("oscar").lastName("pum").phoneNumber("3232323").numberAccount("12121212").build();
        list.add(em);
        final String expected = "[{\"id\":\"123\",\"firstName\":\"oscar\",\"lastName\":\"pum\",\"age\":0,\"phoneNumber\":\"3232323\",\"numberAccount\":\"12121212\"}]";

        Mockito.when(employeeService.listEmployees()).thenReturn(list);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/employee").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), true);
    }

    @Test
    public void addEmployeeTest() throws Exception {
        final String bodyRequest = "{\"id\":\"123\",\"firstName\":\"oscar\",\"lastName\":\"pum\",\"age\":0,\"phoneNumber\":\"3232323\",\"numberAccount\":\"12121212\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee")
                .accept(MediaType.APPLICATION_JSON).content(bodyRequest)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }
    @Test
    public void getEmployeeTest() throws Exception {
        final String id = "123";
        Employee idEmployee = Employee.builder().id(id).build();
        Employee em = Employee.builder().id("123").firstName("oscar").lastName("pum").phoneNumber("3232323").numberAccount("12121212").build();
        final String expected = "{\"id\":\"123\",\"firstName\":\"oscar\",\"lastName\":\"pum\",\"age\":0,\"phoneNumber\":\"3232323\",\"numberAccount\":\"12121212\"}";

        Mockito.when(employeeService.listEmployeeById(idEmployee)).thenReturn(em);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/employee/{id}", id).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), true);
    }

    @Test
    public void deleteClienteNotFoundTest() throws Exception {
        final String id = "123";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
                "/employee/{id}", id).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }

        @Test
    public void deleteClienteTest() throws Exception {
        final String id = "123";
        Employee idEmployee = Employee.builder().id(id).build();
        Employee em = Employee.builder().id("123").firstName("oscar").lastName("pum").phoneNumber("3232323").numberAccount("12121212").build();
        final String expected = "{\"id\":\"123\",\"firstName\":\"oscar\",\"lastName\":\"pum\",\"age\":0,\"phoneNumber\":\"3232323\",\"numberAccount\":\"12121212\"}";

        Mockito.when(employeeService.listEmployeeById(idEmployee)).thenReturn(em);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
                "/employee/{id}", id).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}
