package net.guides.springboot2.springboot2jpacruditservice.itrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacruditservice.itmodel.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
