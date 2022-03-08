package com.restAPI.EmployeeManagement1.Repository;

import com.restAPI.EmployeeManagement1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    // default methods  save,delete ,


}
