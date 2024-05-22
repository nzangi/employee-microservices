package com.nzangi.departmentservice.entity;

import com.nzangi.employeeservice.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department_table")
public class Department {
    @Id
    private Long departmentId;
    private String departmentName;

    @Transient
    private List<Employee> employees;
}
