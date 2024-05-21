package com.nzangi.departmentservice.service;

import com.nzangi.departmentservice.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    List<Department> findAllDepartments();
    Department createDepartment(Department department);
    Department findDepartmentById(Long departmentId);
    Department updateDepartment(Long departmentId,Department departmentDetails);
    void deleteDepartment(Long departmentId);


}
