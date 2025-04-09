package com.firstSpring.restApiTutorial.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.firstSpring.restApiTutorial.dto.EmployeeDTO;
import com.firstSpring.restApiTutorial.entity.EmployeeEntity;
import com.firstSpring.restApiTutorial.respository.EmployeeRespository;

@Service
public class EmployeeService {

    final EmployeeRespository employeeRespository;
    final ModelMapper modelMapper;
    public EmployeeService(EmployeeRespository employeeRespository, ModelMapper modelMapper) {
        this.employeeRespository = employeeRespository;
        this.modelMapper = modelMapper;
    }
    
    public EmployeeDTO getEmployeeById(Long id){
       EmployeeEntity employeeEntity =  employeeRespository.getById(id);
       return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getDoj(), employeeEntity.isActive());
    }
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(employeeRespository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployee() {

      return employeeRespository
       .findAll()
       .stream()
       .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
       .collect(Collectors.toList());
    }
    public boolean deleteEmployeeById(Long id){
        boolean isPresent = employeeRespository.existsById(id);
        if(!isPresent) return false;
        else{
            employeeRespository.deleteById(id);
            return true;
        }
    }
}
