package com.bl.employeepayroll.service;

import com.bl.employeepayroll.email.EmailService;
import com.bl.employeepayroll.entity.EmployeeData;
import com.bl.employeepayroll.exception.EmployeePayrollException;
import com.bl.employeepayroll.repository.EmpRepository;
import com.bl.employeepayroll.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//in Service class we write all the logics, methods called by the controller class
@Service
public class EmpPayrollService implements IPayrollService{
    //created object of empRepository using @Autowired Annotation
    @Autowired
    EmpRepository empRepository;

    @Autowired
    EmailService emailService;

    public EmployeeData getEmployeeById(long empId) {
        return empRepository.findById(empId).orElseThrow(()->new EmployeePayrollException("Employee id " + empId + " not found!"));
    }

    public List<EmployeeData> getAllEmployee() {
        if (!empRepository.findAll().isEmpty()){
            return empRepository.findAll();
        } else {
            throw new EmployeePayrollException("Employee Table is Empty");
        }
    }

    public EmployeeData addEmployee(EmployeeDTO employeeDTO){
        EmployeeData employeeData=new EmployeeData(employeeDTO);
        EmployeeData employeeData1 = empRepository.save(employeeData);
        emailService.sendEmail(employeeData.getEmail(), "Employee Registration Successful!", "Hello " + employeeData.getName() + ", \nYou have successfully registered on the EmployeePayroll Application. \n Your Employee id is " + employeeData.getId());
        return employeeData1;
    }

    public EmployeeData updateEmployee(long empId, EmployeeDTO employeeDTO) {
        if (empRepository.existsById(empId)){
            EmployeeData employeeData = new EmployeeData(employeeDTO);
            employeeData.setId(empId);
            return empRepository.save(employeeData);
        } else {
            throw new EmployeePayrollException("Employee id " + empId + " not found!");
        }
    }

    public void deleteEmployeeById(long empId) {
        if (empRepository.existsById(empId)){
            empRepository.deleteById(empId);
        } else {
            throw new EmployeePayrollException("Employee id " + empId + " not found!");
        }
    }
}
