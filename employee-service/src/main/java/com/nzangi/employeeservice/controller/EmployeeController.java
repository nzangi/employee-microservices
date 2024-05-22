package com.nzangi.employeeservice.controller;

import com.nzangi.employeeservice.entity.Employee;
import com.nzangi.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // find all Employee
    @GetMapping
    public ResponseEntity<List<Employee>> findAllDepartments(){
        List<Employee> employees = employeeService.findAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // find by department id
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Employee>> findEmployeeByDepartmentId(@PathVariable Long departmentId){
        List<Employee> employees = employeeService.findEmployeeByDepartmentId(departmentId);
        return ResponseEntity.ok(employees);
    }

    //get Employee by id
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> findDepartmentById(@PathVariable Long employeeId){
        Employee employee = employeeService.findEmployeeById(employeeId);
        return ResponseEntity.ok(employee);
    }

    //create a Employee
    @PostMapping
    public ResponseEntity<Employee> createDepartment(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    //update Employee
    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateDepartment(@PathVariable Long employeeId,@RequestBody Employee employeeDetails){
        Employee employee = employeeService.updateEmployee(employeeId,employeeDetails);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    //delete Employee
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully!");
    }
}
