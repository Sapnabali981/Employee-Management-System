package com.sapna.Employee.Management.System.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sapna.Employee.Management.System.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	@Modifying
	@Query("UPDATE Employee e SET e.deleted=true where e.id=:id")
	void softDeleteById(@Param("id")int id);
	
    List<Employee> findByDeletedFalse();

    
   
}
