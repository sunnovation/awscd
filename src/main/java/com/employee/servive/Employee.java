package com.employee.servive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer empId;
    private String empName;
    private String department;
    private String gender;
    private Double salary;
}
