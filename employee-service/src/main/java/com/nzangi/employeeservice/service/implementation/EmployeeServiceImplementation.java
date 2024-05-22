package com.nzangi.employeeservice.service.implementation;

import com.nzangi.employeeservice.entity.Employee;
import com.nzangi.employeeservice.repositoty.EmployeeRepository;
import com.nzangi.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImplementation implements EmployeeService {

    //constructor dependency injection

    private EmployeeRepository employeeRepository;
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    //find all employees on db
    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    // find department by id
    @Override
    public List<Employee> findEmployeeByDepartmentId(Long departmentId) {
        List<Employee> employees = employeeRepository.findByDepartmentId(departmentId);
        return employees;
    }

    //add employee to db
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // find employee by db
    @Override
    public Employee findEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new RuntimeException("No employee with such employeeId")
        );

        return employee;
    }

    // update employee
    @Override
    public Employee updateEmployee(Long employeeId, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new RuntimeException("No employee with such employeeId")
        );

        employee.setEmployeeId(employeeDetails.getEmployeeId());
        employee.setDepartmentId(employeeDetails.getDepartmentId());
        employee.setEmployeeName(employeeDetails.getEmployeeName());
        employee.setEmployeePosition(employeeDetails.getEmployeePosition());
        return employeeRepository.save(employee);
    }

    // delete employee
    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new RuntimeException("No employee with such employeeId")
        );

        employeeRepository.deleteById(employeeId);
    }
}
