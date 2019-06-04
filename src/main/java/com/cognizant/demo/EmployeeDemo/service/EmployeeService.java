package com.cognizant.demo.EmployeeDemo.service;

import com.cognizant.demo.EmployeeDemo.Repositories.EmployeeRepo;
import com.cognizant.demo.EmployeeDemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee()
    {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(long id){
        return  employeeRepo.findById(id).get();
    }

    public void addEmployee(Employee employee)
    {
        System.out.println(employee);
        employeeRepo.save(employee);
    }

    public  void deleteEmployeeById(long id){
        employeeRepo.deleteById(id);
    }

    public void updateEmployeeAddress(long id,String address){
        Employee employee=employeeRepo.findById(id).get();
        employee.setAddress(address);
        employeeRepo.save(employee);
    }
}
