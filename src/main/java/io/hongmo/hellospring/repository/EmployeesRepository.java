package io.hongmo.hellospring.repository;

import io.hongmo.hellospring.domain.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
}
