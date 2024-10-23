package com.employee.servive;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {


    @PostMapping("/add-employee")
    public ResponseEntity<HashMap<String,Object>> addEmployeeList() {
        HashMap<String, Object> response = new HashMap<String, Object>();

        response.put("status", true);
        response.put("payload", fetchEmployees());
        response.put("code", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all-employees")
    public ResponseEntity<HashMap<String,Object>> fetchEmployeeList() {
        HashMap<String, Object> response = new HashMap<String, Object>();

        response.put("status", true);
        response.put("payload",
                fetchEmployees().stream()
                        .sorted((emp1,emp2)->emp1.getEmpId()-emp2.getEmpId()).collect(Collectors.toUnmodifiableList()));
        response.put("code", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all-employeesdsc")
    public ResponseEntity<HashMap<String,Object>> fetchEmployeeListWithDSC() {
        HashMap<String, Object> response = new HashMap<String, Object>();

        response.put("status", true);
        response.put("payload",
                fetchEmployees().stream()
                        .sorted((emp1,emp2)->emp2.getEmpId()-emp1.getEmpId()).collect(Collectors.toUnmodifiableList()));
        response.put("code", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/gender")
    public ResponseEntity<HashMap<String,Object>> fetchGenderwise(@RequestParam String filter) {
        HashMap<String, Object> response = new HashMap<String, Object>();

        response.put("status", true);
        response.put("payload",
                fetchEmployees().stream().filter(employee ->employee.getGender().equalsIgnoreCase(filter))
                        .sorted((emp1,emp2)->emp2.getEmpId()-emp1.getEmpId()).collect(Collectors.toUnmodifiableList()));
        response.put("code", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    private List<Employee> fetchEmployees(){
        return List.of(
                new Employee(101, "Pawan Barthunia",
                        "FSSP", "Male", 2345678.89),
                new Employee(102, "Ritesh Barthonia",
                        "RSK", "Male", 1345678.89),
                new Employee(103, "Pankaj Panth",
                        "FSSP", "Male", 4345678.89),
                new Employee(104, "Vishvanath Kadam",
                        "FSSP", "Male", 3345678.89),
                new Employee(105, "Ashok Varma",
                        "Jeffries", "Male", 345678.89),
                new Employee(106, "Meghna Jaiswal",
                        "UBS", "Male", 45678.89),
                new Employee(107, "Ulka Matakor",
                        "HR", "Male", 2745678.89),
                new Employee(108, "Jignesh Varma",
                        "HR", "Male", 1845678.89),
                new Employee(109, "Mukesh Kumar",
                        "PMO", "Male", 2045678.89),
                new Employee(110, "Manoj Kumar",
                        "Jeffries", "Male", 2645678.89)

        );
    }
}
