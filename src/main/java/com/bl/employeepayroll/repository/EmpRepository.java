package com.bl.employeepayroll.repository;

import com.bl.employeepayroll.entity.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//EmpRepository extends JpaRepository is used to call the methods to manage Database
@Repository
public interface EmpRepository extends JpaRepository<EmployeeData, Long> {
}
