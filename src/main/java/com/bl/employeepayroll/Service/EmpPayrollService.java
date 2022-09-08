package com.bl.employeepayroll.Service;

import com.bl.employeepayroll.Entity.EmployeeData;
import com.bl.employeepayroll.Exception.EmployeePayrollException;
import com.bl.employeepayroll.Repository.EmpRepository;
import com.bl.employeepayroll.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//in Service class we write all the logics, methods called by the controller class
@Service
public class EmpPayrollService implements IPayrollService{
    //created object of empRepository using @Autowired Annotation
    @Autowired
    EmpRepository empRepository;

    public Optional<EmployeeData> getEmployeeById(long empId) {
        if (empRepository.findById(empId).isPresent()){
            return empRepository.findById(empId);
        } else {
            throw new EmployeePayrollException("Employee id " + empId + " not found!");
        }
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
        return empRepository.save(employeeData);
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
