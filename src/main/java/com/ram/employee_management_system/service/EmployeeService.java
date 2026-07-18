package com.ram.employee_management_system.service;

import com.ram.employee_management_system.exception.EmployeeNotFoundException;
import com.ram.employee_management_system.exception.ResourceNotFoundException;
import com.ram.employee_management_system.model.Employee;
import com.ram.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Save Employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee By Id
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id :" + id));
    }

    public Employee getEmployeeByName(String name){

        return employeeRepository.findByName(name)
                .orElseThrow(()-> new


                        ResourceNotFoundException("Employee Not Found"));
    }

    // Update Employee
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Delete Employee
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeeByDepartment(String department) {

        return employeeRepository.findByDepartment(department);

    }

    public Page<Employee> getEmployeesWithPagination(int page, int size){

        Pageable pageable = PageRequest.of(page,size);

        return employeeRepository.findAll(pageable);
    }

    public List<Employee> getEmployeesSorted(String field){

        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<Employee> getEmployeesWithPaginationAndSorting(int page,
                                                               int size,
                                                               String field){

        Pageable pageable =
                PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, field));

        return employeeRepository.findAll(pageable);

    }
}