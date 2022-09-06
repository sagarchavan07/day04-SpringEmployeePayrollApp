package com.bl.employeepayroll.Service;

import com.bl.employeepayroll.Entity.EmployeeData;

import java.util.Optional;

public interface IPayrollService {
    public Optional getEmployeeDataById(long empId);
    public EmployeeData addEmployee(EmployeeData employee);
    public EmployeeData updateEmployee(long empId, EmployeeData employeeData);
    public void deleteEmployeeById(long empId);
}
