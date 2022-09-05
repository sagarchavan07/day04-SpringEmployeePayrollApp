package com.bl.employeepayroll.Controller;

import com.bl.employeepayroll.Entity.Employee;
import com.bl.employeepayroll.Service.EmpPayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity<String> getEmpPayrollDataById(@PathVariable String empId){
        return new ResponseEntity<>("GET call success for empId: "+empId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>("Created Employee "+employee , HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>("Updated Employee "+employee , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> updateEmployee(@PathVariable int empId){
        return new ResponseEntity<>("Deleted Employee empId: "+empId , HttpStatus.OK);
    }
}
