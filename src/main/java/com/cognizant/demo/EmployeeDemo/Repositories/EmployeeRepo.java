package com.cognizant.demo.EmployeeDemo.Repositories;

import com.cognizant.demo.EmployeeDemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee,Long> {
}
