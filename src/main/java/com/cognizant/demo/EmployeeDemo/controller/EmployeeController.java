package com.cognizant.demo.EmployeeDemo.controller;

import com.cognizant.demo.EmployeeDemo.model.Employee;
import com.cognizant.demo.EmployeeDemo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://18.222.213.31:80")
@Api(value = "Employee Management system")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    
    @ApiOperation(value = "View a list of all available employee",response = List.class)
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
    	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
    	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    	})
    @GetMapping(value = "/all",produces = "application/json")
    @ResponseBody
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    
    @ApiOperation(value = "Get an employee by Id")
    @GetMapping(value="/{id}",produces = "application/json")
    @ResponseBody
    public Employee getEmployee( @ApiParam(value = "Employee id from which employee object will retrieve", required = true)@PathVariable("id") long id){
        return  employeeService.getEmployeeById(id);
    }

    @ApiOperation(value = "Add an employee")
    @PostMapping(value = "/add", produces = "application/json")
    @ResponseBody
    public void addEmployee(@ApiParam(value = "Employee object need to store in database",required = true)@RequestBody Employee employee){
        System.out.println(" --employee" +employee);
        employeeService.addEmployee(employee);
    }
    
    @ApiOperation(value = "Delete an employee")
    @DeleteMapping("/remove/{id}")
    public void deleteEmployee(@ApiParam(value = "Employee Id from which employee object will delete from database table", required = true)@PathVariable("id") long id){
        employeeService.deleteEmployeeById(id);
    }


    @ApiOperation(value = "Update an employee")
    @PutMapping("/update/{id}/{addr}")
    @ResponseBody
    public void updateEmployee(@ApiParam(value = "Employee id whose address need to be update", required = true)@PathVariable("id") long id,@ApiParam(value = "new address",required = true)@PathVariable("addr") String addr){
        employeeService.updateEmployeeAddress(id,addr);
    }
}
