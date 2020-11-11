package com.iri.thymeleafsbdatajpa.service;

import com.iri.thymeleafsbdatajpa.dao.EmployeeRepository;
import com.iri.thymeleafsbdatajpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeRepositoryServiceImpl implements EmployeeRepositoryService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeRepositoryServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {

        //return employeeRepository.findAll();
        return  employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        Employee theEmployee = null;

        if (employee.isPresent()) {
            return employee.get();
        } else {

            throw new RuntimeException(

                    "Dont find employee with id " + id
            );
        }


    }

    @Override
    public void save(Employee employee) {

        employeeRepository.save(employee);

    }

    @Override
    public void deleteById(int id) {

        employeeRepository.deleteById(id);

    }
}
