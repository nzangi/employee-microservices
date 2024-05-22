package com.nzangi.employeeservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employee_service")
public class Employee {
    @Id
    private Long employeeId;
    private Long departmentId;
    private String employeeName;
    private String employeePosition;

}
