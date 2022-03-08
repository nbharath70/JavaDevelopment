package com.restAPI.EmployeeManagement1.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    Long code;
    String message;
    java.lang.Object result;
}
