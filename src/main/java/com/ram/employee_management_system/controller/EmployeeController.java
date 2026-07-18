package com.ram.employee_management_system.controller;

import com.ram.employee_management_system.dto.EmployeeDTO;
import com.ram.employee_management_system.model.Employee;
import com.ram.employee_management_system.service.EmployeeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    // Save Employee
/*    @PostMapping
    public Employee saveEmployee(@Valid @RequestBody EmployeeDTO dto) {

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setDepartment(dto.getDepartment());
        employee.setEmail(dto.getEmail());
        return service.saveEmployee(employee);
    }*/

    // Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {

        logger.info("Fetching All Employees");
        return service.getAllEmployees();
    }

    // Get Employee By Id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){

        logger.info("Fetching Employee By Id : {}", id);
        Employee employee = service.getEmployeeById(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeDTO dto){

        logger.info("Creating Employee : {}", dto.getName());
        Employee employee = new Employee();


        employee.setName(dto.getName());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());

        Employee savedEmployee = service.saveEmployee(employee);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){

        logger.info("Deleting Employee : {}", id);

        service.deleteEmployee(id);

        return new ResponseEntity<>("Employee Deleted Successfully",HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee){

        logger.info("Updating Employee : {}", employee.getId());

        Employee updated = service.updateEmployee(employee);

        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public Employee getEmployeeByName(@PathVariable String name) {

        return service.getEmployeeByName(name);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String department) {

        return service.getEmployeeByDepartment(department);

    }

    @GetMapping("/pagination")
    public Page<Employee> getEmployeesWithPagination(

            @RequestParam int page,
            @RequestParam int size) {

        return service.getEmployeesWithPagination(page,size);
    }

    @GetMapping("/sort/{field}")
    public List<Employee> getEmployeesSorted(@PathVariable String field){

        return service.getEmployeesSorted(field);
    }

    @GetMapping("/paginationSort")
    public Page<Employee> getEmployeesWithPaginationAndSorting(

            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String field){

        return service.getEmployeesWithPaginationAndSorting(page, size, field);

    }



    // Update Employee
/*    @PutMapping
    public Employee updateEmployee(@Valid @RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }*/

    // Delete Employee
/*    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {

        service.deleteEmployee(id);

        return "Employee Deleted Successfully";
    }*/
}