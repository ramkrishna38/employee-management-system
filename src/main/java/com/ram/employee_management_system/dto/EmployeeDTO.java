package com.ram.employee_management_system.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmployeeDTO {

    @NotBlank(message="Employee name is required")
    private String name;

    @NotBlank(message="Department is required")
    private String department;

    @Email(message="Enter valid email")
    private String email;

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
}
