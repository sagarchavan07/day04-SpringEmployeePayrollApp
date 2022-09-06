package com.bl.employeepayroll.Controller;

import com.bl.employeepayroll.Entity.EmployeeData;
import com.bl.employeepayroll.Service.EmpPayrollService;
import com.bl.employeepayroll.dto.EmployeeDTO;
import com.bl.employeepayroll.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employeepayrollapp")
public class EmpController {

    @Autowired
    EmpPayrollService empPayrollService;

    @GetMapping(value = {"","/","get"})
    ResponseEntity<String> getEmpPayrollData(){
        return new ResponseEntity<>("GET call success", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    ResponseEntity<ResponseDTO> getEmpPayrollDataById(@PathVariable long empId){
        ResponseDTO responseDTO = new ResponseDTO("GET call successful",empPayrollService.getEmployeeDataById(empId) );
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        EmployeeData employee=new EmployeeData(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee added successfully", empPayrollService.addEmployee(employee));
        return new ResponseEntity<>( responseDTO , HttpStatus.CREATED);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable long empId){
        EmployeeData employeeData = new EmployeeData(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee", empPayrollService.updateEmployee(empId, employeeData));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long empId){
        empPayrollService.deleteEmployeeById(empId);
        return new ResponseEntity<>("Deleted Employee empId: "+empId , HttpStatus.OK);
    }
}
