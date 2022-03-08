package com.restAPI.EmployeeManagement1.Controller;

import com.restAPI.EmployeeManagement1.Exception.ResponseObject;
import com.restAPI.EmployeeManagement1.model.Employee;
import com.restAPI.EmployeeManagement1.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("addEmployee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("getEmployee/{id}")
    public ResponseEntity<ResponseObject> getEmployee(@PathVariable Long id){
       return   employeeService.getEmployee(id);
    }

    @DeleteMapping("deleteEmployee")
    public  ResponseEntity<ResponseObject> deleteEmployee(@RequestBody  Employee employee){
        return employeeService.deleteEmployee(employee.getId());
    }

    @PutMapping("updateEmployee")
    public ResponseEntity<ResponseObject> updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
}
