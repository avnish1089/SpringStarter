package com.firstSpring.restApiTutorial.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // coming from lombok dependency and it takes care to have gettors settors, constructos
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private long id;
private String name;
private LocalDate doj;
private boolean isActive;

}
