package com.innovedcol.ecofamily.repositories;

import com.innovedcol.ecofamily.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    Optional<Employee> findByName(String name);

    Optional<Employee> findByEnterprise(Long enterpriseID);
}
