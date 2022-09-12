package com.bl.employeepayroll.service;

import com.bl.employeepayroll.Utility.TokenUtility;
import com.bl.employeepayroll.dto.ResponseDTO;
import com.bl.employeepayroll.email.EmailService;
import com.bl.employeepayroll.entity.EmployeeData;
import com.bl.employeepayroll.exception.EmployeePayrollException;
import com.bl.employeepayroll.repository.EmpRepository;
import com.bl.employeepayroll.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    TokenUtility tokenUtility;

    public ResponseEntity<ResponseDTO> getEmployeeById(long empId) {
        EmployeeData employeeData = empRepository.findById(empId).orElseThrow(() -> new EmployeePayrollException("Employee id " + empId + " not found!"));
        ResponseDTO responseDTO = new ResponseDTO("GET call successful", employeeData );
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getEmployeeByName(String name) {
        List<EmployeeData> employeeDataList = empRepository.findEmployeeByName(name);
        if (!employeeDataList.isEmpty()){
            ResponseDTO responseDTO = new ResponseDTO("GET call successful", employeeDataList );
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else
        throw new EmployeePayrollException("Employee with name " + name + " not found!");
    }

    public ResponseEntity<ResponseDTO> getAllEmployee() {
        if (!empRepository.findAll().isEmpty()){
            ResponseDTO responseDTO = new ResponseDTO("GET call successful", empRepository.findAll() );
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            throw new EmployeePayrollException("Employee Table is Empty");
        }
    }

    public ResponseEntity<ResponseDTO> addEmployee(EmployeeDTO employeeDTO){
        EmployeeData employeeData = empRepository.save(new EmployeeData(employeeDTO));
        ResponseDTO responseDTO = new ResponseDTO("Employee added successfully", employeeData);

        String token = tokenUtility.generateToken(employeeData.getId());
        long id = tokenUtility.decodeToken(token);
        emailService.sendEmail(employeeData.getEmail(), "Employee Registration Successful!", "Hello " + employeeData.getName() + ", \nYou have successfully registered on the EmployeePayroll Application. \nYour Employee id is " + id + "\ntoken: " + token);

        return new ResponseEntity<>( responseDTO , HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseDTO> updateEmployee(long empId, EmployeeDTO employeeDTO) {
        if (empRepository.existsById(empId)){
            EmployeeData employeeData = new EmployeeData(employeeDTO);
            employeeData.setId(empId);
            ResponseDTO responseDTO = new ResponseDTO("Updated Employee", empRepository.save(employeeData) );
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            throw new EmployeePayrollException("Employee id " + empId + " not found!");
        }
    }

    public ResponseEntity<String> deleteEmployeeById(long empId) {
        if (empRepository.existsById(empId)){
            empRepository.deleteById(empId);
            return new ResponseEntity<>("Deleted Employee empId: "+empId , HttpStatus.OK);
        } else {
            throw new EmployeePayrollException("Employee id " + empId + " not found!");
        }
    }
}
