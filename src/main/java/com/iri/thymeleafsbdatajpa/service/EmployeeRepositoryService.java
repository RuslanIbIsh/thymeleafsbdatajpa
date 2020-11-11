package com.iri.thymeleafsbdatajpa.service;

import com.iri.thymeleafsbdatajpa.entity.Employee;

import java.util.List;

public interface EmployeeRepositoryService {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
