package com.restAPI.EmployeeManagement1.services;

import com.restAPI.EmployeeManagement1.Exception.ResponseObject;
import com.restAPI.EmployeeManagement1.Repository.EmployeeRepo;
import com.restAPI.EmployeeManagement1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee saveEmployee(Employee employee){
      return   employeeRepo.save(employee);
    }

    public ResponseEntity<ResponseObject> getEmployee(Long id) {
        Optional<Employee> employee= employeeRepo.findById(id);
        ResponseObject responseObject ;
        if(employee.isPresent()){
            responseObject =new ResponseObject(200L,"Record Found",employee.get());
        }else {
            responseObject = new ResponseObject(201L,"Record Not Found",null);
        }
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    public ResponseEntity<ResponseObject> deleteEmployee(Long id) {
        Optional <Employee> employee=employeeRepo.findById(id);
        ResponseObject responseObject;
        if(employee.isPresent()){
            employeeRepo.delete(employee.get());
            responseObject =new ResponseObject(200L,"Record deleted Sucessfully",null);
        }else {
            responseObject=new ResponseObject(201L,"Record Not Found for this id",null);
        }
        return new ResponseEntity<>(responseObject,HttpStatus.OK);
    }

    public ResponseEntity<ResponseObject> updateEmployee(Employee employee) {
        Optional <Employee> employe=employeeRepo.findById(employee.getId());
        ResponseObject responseObject;
        if (employe.isPresent()){
            Employee emp=employe.get();
            emp.setName(employee.getName());
            emp.setAddress(employee.getAddress());
            emp.setSalary(employee.getSalary());
            employeeRepo.save(emp);
            responseObject=new ResponseObject(200L,"Record updated Successfully",emp);
        }else {
            responseObject=new ResponseObject(201L,"Rcord not found to update this record",null);
        }
        return new ResponseEntity<>(responseObject,HttpStatus.OK);
    }
}
