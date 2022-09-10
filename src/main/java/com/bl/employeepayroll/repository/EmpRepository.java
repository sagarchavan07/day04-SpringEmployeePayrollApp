package com.bl.employeepayroll.repository;

import com.bl.employeepayroll.entity.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//EmpRepository extends JpaRepository is used to call the methods to manage Database
@Repository
public interface EmpRepository extends JpaRepository<EmployeeData, Long> {
    @Query(value = "SELECT * FROM employee_data e WHERE e.name = :empName", nativeQuery = true)
    List<EmployeeData> findEmployeeByName(@Param("empName") String employeeName);

    @Query(value = "SELECT * FROM employee_data e WHERE e.id = :id", nativeQuery = true)
    EmployeeData findEmployeeDataByIdsById(@Param("id")int id);
}
