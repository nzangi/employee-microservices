package com.nzangi.departmentservice.client;

import com.nzangi.employeeservice.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface EmployeeClient {
    @GetExchange("/employee/department/{departmentId}")
    public ResponseEntity<List<Employee>> findEmployeeByDepartmentId(@PathVariable Long departmentId);
}
