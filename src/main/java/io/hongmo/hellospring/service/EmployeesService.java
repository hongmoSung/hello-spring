package io.hongmo.hellospring.service;

import io.hongmo.hellospring.domain.Employees;
import io.hongmo.hellospring.repository.EmployeesRepository;

import java.util.List;

public class EmployeesService {
    private final EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> findAll() {
        return employeesRepository.findAll();
    }
}
