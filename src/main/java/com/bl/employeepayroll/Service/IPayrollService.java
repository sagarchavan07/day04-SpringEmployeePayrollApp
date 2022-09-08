package com.bl.employeepayroll.Service;

import com.bl.employeepayroll.Entity.EmployeeData;
import com.bl.employeepayroll.Exception.EmployeePayrollException;
import com.bl.employeepayroll.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface IPayrollService {
    Optional getEmployeeById(long empId) ;
    List<EmployeeData> getAllEmployee() ;
    EmployeeData addEmployee(EmployeeDTO employeeDTO);
    EmployeeData updateEmployee(long empId, EmployeeDTO employeeDTO) ;
    void deleteEmployeeById(long empId) ;
}
