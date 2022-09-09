package com.bl.employeepayroll.entity;

import com.bl.employeepayroll.dto.EmployeeDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//EmployeeData is responsible to save the employee data to Database
@Entity
public class EmployeeData {
    //id is auto generated primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    private List<String> department;
    private String profilePic;
    private String email;
    private String gender;
    private String salary;
    private LocalDate startDate;
    private String notes;

    public EmployeeData() {
    }

    public EmployeeData(String name, List<String> department, String profilePic, String email, String gender, String salary, LocalDate startDate, String notes) {
        this.name = name;
        this.department=department;
        this.profilePic = profilePic;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
        this.startDate = startDate;
        this.notes = notes;
    }

    public EmployeeData(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.department=employeeDTO.getDepartment();
        this.profilePic = employeeDTO.getProfilePic();
        this.email = employeeDTO.getEmail();
        this.gender = employeeDTO.getGender();
        this.salary = employeeDTO.getSalary();
        this.startDate = employeeDTO.getStartDate();
        this.notes = employeeDTO.getNotes();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "EmployeeData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", profilePic='" + profilePic + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", salary='" + salary + '\'' +
                ", startDate=" + startDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}
