package com.nzangi.employeeservice.service;

import com.nzangi.employeeservice.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
    List<Employee> findAllEmployees();
    List<Employee> findEmployeeByDepartmentId(Long employeeId);
    Employee createEmployee(Employee employee);
    Employee findEmployeeById(Long employeeId);
    Employee updateEmployee(Long employeeId,Employee employeeDetails);
    void deleteEmployee(Long employeeId);
}
