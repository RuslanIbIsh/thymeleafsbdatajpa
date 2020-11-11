package com.iri.thymeleafsbdatajpa.controller;

import com.iri.thymeleafsbdatajpa.entity.Employee;
import com.iri.thymeleafsbdatajpa.service.EmployeeRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private EmployeeRepositoryService employeeRepositoryService;

    @Autowired
    public EmployeeController(EmployeeRepositoryService employeeRepositoryService) {
        this.employeeRepositoryService = employeeRepositoryService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Employee> employees = employeeRepositoryService.findAll();

        model.addAttribute("employees", employees);

        return "/employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Employee theEmployee = new Employee();
        model.addAttribute("employee", theEmployee);

        return "/employees/employee-form";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeRepositoryService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(
            @RequestParam("employeeId") int id,
            Model model
    ) {
        Employee employee = employeeRepositoryService.findById(id);

        model.addAttribute("employee", employee);

        return "/employees/employee-form";

    }

    @GetMapping("delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeRepositoryService.deleteById(id);

        return "redirect:/employees/list";
    }




}
