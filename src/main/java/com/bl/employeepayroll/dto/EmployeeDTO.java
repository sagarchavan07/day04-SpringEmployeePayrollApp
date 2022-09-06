package com.bl.employeepayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;
    @Pattern(regexp = "^[A-Z][\\w\\s]{2,}$", message = "Invalid Name")
    private String name;
    private String profilePic;
    private String gender;
    private String salary;
    private LocalDate startDate;
    private String notes;
}
