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
    @GetMapping(value = {"","/"})
    ResponseEntity<String> getEmpPayrollData(){
        return new ResponseEntity<>("GET call success", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    ResponseEntity<ResponseDTO> getEmpPayrollDataById(@PathVariable long empId) {
        return empPayrollService.getEmployeeById(empId);

    }

    @GetMapping("/get")
    ResponseEntity<ResponseDTO> getEmpPayrollDataByName(@RequestParam String name) {
        return empPayrollService.getEmployeeByName(name);
    }

    @GetMapping("/get/all")
    ResponseEntity<ResponseDTO> getAllEmpPayrollData() {
        return empPayrollService.getAllEmployee();
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        return  empPayrollService.addEmployee(employeeDTO);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable long empId) {
        return empPayrollService.updateEmployee(empId, employeeDTO);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long empId){
        return empPayrollService.deleteEmployeeById(empId);
    }
}
