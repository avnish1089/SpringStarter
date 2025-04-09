package com.firstSpring.restApiTutorial.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstSpring.restApiTutorial.entity.EmployeeEntity;

@Repository
public interface EmployeeRespository extends JpaRepository<EmployeeEntity, Long>{

    
}