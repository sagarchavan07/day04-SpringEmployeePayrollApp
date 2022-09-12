package com.bl.employeepayroll.service;

import com.bl.employeepayroll.dto.ResponseDTO;
import com.bl.employeepayroll.entity.EmployeeData;
import com.bl.employeepayroll.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPayrollService {
    ResponseEntity<ResponseDTO> getEmployeeById(long empId) ;
    ResponseEntity<ResponseDTO> getEmployeeByName(String name);
    ResponseEntity<ResponseDTO> getAllEmployee();
    ResponseEntity<ResponseDTO>  addEmployee(EmployeeDTO employeeDTO);
    ResponseEntity<ResponseDTO>  updateEmployee(long empId, EmployeeDTO employeeDTO) ;
    ResponseEntity<String> deleteEmployeeById(long empId) ;
}
