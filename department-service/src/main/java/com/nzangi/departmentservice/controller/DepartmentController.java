package com.nzangi.departmentservice.controller;

import com.nzangi.departmentservice.client.EmployeeClient;
import com.nzangi.departmentservice.entity.Department;
import com.nzangi.departmentservice.service.DepartmentService;
import com.nzangi.employeeservice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    //DI
    private DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }
    @Autowired
    private EmployeeClient employeeClient;

    // find all departments
    @GetMapping
    public ResponseEntity<List<Department>> findAllDepartments(){
        List<Department> departments = departmentService.findAllDepartments();
        return ResponseEntity.ok(departments);
    }

    //get department by id
    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable Long departmentId){
        Department department = departmentService.findDepartmentById(departmentId);
        return ResponseEntity.ok(department);
    }

    //create a department
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }

    //update department
    @PutMapping("/{departmentId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long departmentId,@RequestBody Department departmentDetails){
        Department department = departmentService.updateDepartment(departmentId,departmentDetails);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }

    //delete department
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department Deleted Successfully!");
    }

    @GetMapping("/with-employees")
    public List<Department> findAllDepartmentsWithEmployees(){
        List<Department> departments = departmentService.findAllDepartments();
        departments.forEach( department ->
                {
                    List<Employee> employees = employeeClient.findEmployeeByDepartmentId(department.getDepartmentId()).getBody();
                    department.setEmployees(employees);
                }
        );
        return departments;

    }





}
