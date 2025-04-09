package com.firstSpring.restApiTutorial.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpring.restApiTutorial.dto.EmployeeDTO;
import com.firstSpring.restApiTutorial.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;





// get // employees
// post // employees
// delete

// public String requestMethodName(@RequestParam String param) {
//     return new String();
// }
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployees(@PathVariable("id") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return  employeeService.createNewEmployee(employeeDTO);
        
    }

    @GetMapping(path = "/getAll")
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable("id") Long id) {
        return employeeService.deleteEmployeeById(id);
    }
    
}
