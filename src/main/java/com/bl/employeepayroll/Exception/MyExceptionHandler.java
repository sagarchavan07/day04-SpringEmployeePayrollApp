package com.bl.employeepayroll.Exception;

import com.bl.employeepayroll.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> CustomEmployeePayrollException(EmployeePayrollException exception){
        ResponseDTO responseDTO = new ResponseDTO("ERROR! => EmployeePayrollException", exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
