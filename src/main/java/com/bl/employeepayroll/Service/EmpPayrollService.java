package com.bl.employeepayroll.Service;

import com.bl.employeepayroll.Entity.EmployeeData;
import com.bl.employeepayroll.Repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpPayrollService implements IPayrollService{
    @Autowired
    EmpRepository empRepository;

    public Optional getEmployeeDataById(long empId){
        return empRepository.findById(empId);
    }

    public EmployeeData addEmployee(EmployeeData employeeData){
        return empRepository.save(employeeData);
    }

    public EmployeeData updateEmployee(long empId, EmployeeData employeeData){
        employeeData.setId(empId);
        return empRepository.save(employeeData);
    }

    public void deleteEmployeeById(long empId){
        empRepository.deleteById(empId);
    }
}
