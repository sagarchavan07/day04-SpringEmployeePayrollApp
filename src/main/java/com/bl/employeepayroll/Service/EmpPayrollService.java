package com.bl.employeepayroll.Service;

import com.bl.employeepayroll.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpPayrollService implements IPayrollService{
    @Autowired
    JpaRepository jpaRepository;
    public Employee addEmployee(Employee employee){
        return (Employee) jpaRepository.save(employee);
    }
}
