package com.bl.employeepayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

//DTO class used to send data from browser to server
//@Data annotation generate methods like getter, setter, toString, hashCode etc.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z][\\w\\s]{2,}$", message = "Invalid Name")
    private String name;
    private List<String> department;
    private String profilePic;
    private String gender;
    private String salary;
    private LocalDate startDate;
    private String notes;
}
