package com.bl.employeepayroll.Repository;

import com.bl.employeepayroll.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {
}
