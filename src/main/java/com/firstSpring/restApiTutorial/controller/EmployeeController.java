package com.firstSpring.restApiTutorial.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpring.restApiTutorial.dto.EmployeeDTO;

// get // employees
// post // employees
// delete
@RestController
public class EmployeeController {

    @GetMapping(path = "/employees")
    public EmployeeDTO getEmployees(){
        return new EmployeeDTO(12, "avnish", LocalDate.of(2025, 12, 07) , true );
    }
}
