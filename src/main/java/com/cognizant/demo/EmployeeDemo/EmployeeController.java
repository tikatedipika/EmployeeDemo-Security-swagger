package com.cognizant.demo.EmployeeDemo;

import com.cognizant.demo.EmployeeDemo.model.Employee;
import com.cognizant.demo.EmployeeDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/all",produces = "application/json")
    @ResponseBody
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping(value="/{id}",produces = "application/json")
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") long id){
        return  employeeService.getEmployeeById(id);
    }

    @PostMapping(value = "/add", produces = "application/json")
    @ResponseBody
    public void addEmployee(@RequestBody Employee employee){
         employeeService.addEmployee(employee);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/update/{id}/{addr}")
    @ResponseBody
    public void updateEmployee(@PathVariable("id") long id,@PathVariable("addr") String addr){
        employeeService.updateEmployeeAddress(id,addr);
    }
}
