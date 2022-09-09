package com.bl.employeepayroll.service;

import com.bl.employeepayroll.entity.EmployeeData;
import com.bl.employeepayroll.dto.EmployeeDTO;

import java.util.List;

public interface IPayrollService {
    EmployeeData getEmployeeById(long empId) ;
    List<EmployeeData> getAllEmployee() ;
    EmployeeData addEmployee(EmployeeDTO employeeDTO);
    EmployeeData updateEmployee(long empId, EmployeeDTO employeeDTO) ;
    void deleteEmployeeById(long empId) ;
}
