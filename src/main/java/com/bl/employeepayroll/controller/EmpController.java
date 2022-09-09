package com.bl.employeepayroll.controller;

import com.bl.employeepayroll.service.EmpPayrollService;
import com.bl.employeepayroll.dto.EmployeeDTO;
import com.bl.employeepayroll.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//EmpController class manage the Rest calls send by client, calls the methods of service send response to browser
@RestController
@RequestMapping("/employeepayrollapp")
public class EmpController {

    //created object of empPayrollService using @Autowired annotation
    @Autowired
    EmpPayrollService empPayrollService;
    @GetMapping(value = {"","/","get"})
    ResponseEntity<String> getEmpPayrollData(){
        return new ResponseEntity<>("GET call success", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    ResponseEntity<ResponseDTO> getEmpPayrollDataById(@PathVariable long empId) {
        ResponseDTO responseDTO = new ResponseDTO("GET call successful",empPayrollService.getEmployeeById(empId) );
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/all")
    ResponseEntity<ResponseDTO> getAllEmpPayrollData() {
        ResponseDTO responseDTO = new ResponseDTO("GET call successful",empPayrollService.getAllEmployee() );
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        ResponseDTO responseDTO = new ResponseDTO("Employee added successfully", empPayrollService.addEmployee(employeeDTO));
        return new ResponseEntity<>( responseDTO , HttpStatus.CREATED);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable long empId) {
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee", empPayrollService.updateEmployee(empId, employeeDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long empId){
        empPayrollService.deleteEmployeeById(empId);
        return new ResponseEntity<>("Deleted Employee empId: "+empId , HttpStatus.OK);
    }
}