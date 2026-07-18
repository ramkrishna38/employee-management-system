package com.ram.employee_management_system.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeDTO {

    @NotBlank(message="Employee name is required")
    private String name;

    @NotBlank(message="Department is required")
    private String department;

    @Email(message="Enter valid email")
    private String email;

    @NotNull(message = "Salary is required")
    private Double salary;

    public EmployeeDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
