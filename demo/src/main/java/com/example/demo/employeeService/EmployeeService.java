package com.example.demo.employeeService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.employeeRepository.EmployeeRepository;
import com.example.demo.entity.Employee;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setAge(updatedEmployee.getAge());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setRole(updatedEmployee.getRole());
        return repository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
