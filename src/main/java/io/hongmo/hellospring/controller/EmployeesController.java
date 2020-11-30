package io.hongmo.hellospring.controller;

import io.hongmo.hellospring.domain.Employees;
import io.hongmo.hellospring.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeesController {
    private EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping("/employees")
    @ResponseBody
    public List<Employees> findAll() {
        return employeesService.findAll();
    }
}
