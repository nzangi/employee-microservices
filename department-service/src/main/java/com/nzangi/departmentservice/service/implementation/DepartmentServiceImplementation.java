package com.nzangi.departmentservice.service.implementation;

import com.nzangi.departmentservice.entity.Department;
import com.nzangi.departmentservice.repositoty.DepartmentRepository;
import com.nzangi.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImplementation implements DepartmentService {
    //DI of DepartmentRepository
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImplementation(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }

    // find all departments in DB
    @Override
    public List<Department> findAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    //Create a department
    @Override
    public Department createDepartment(Department department) {
        // save the department to db
        return departmentRepository.save(department);
    }

    // find department on db
    @Override
    public Department findDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new RuntimeException("No department with such departmentId")
        );
        return department;
    }

    //Update department
    @Override
    public Department updateDepartment(Long departmentId,Department departmentDetails) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new RuntimeException("No department with such departmentId")
        );

        department.setDepartmentId(departmentDetails.getDepartmentId());
        department.setDepartmentName(departmentDetails.getDepartmentName());
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new RuntimeException("No department with such departmentId")
        );
        departmentRepository.deleteById(departmentId);
    }
}
