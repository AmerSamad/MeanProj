package amer.meanProj.employeemanager.repo;

import amer.meanProj.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Using JPA Repo to avoid implementing the JDBC logic. It has all the operations required to work with databases
public interface EmployeeRepo extends JpaRepository<Employee,Long>{
    // Method string. String automatically created the logic from the method name.
    // In this case it create logic to delete employee by id
    void deleteEmployeeById(Long id);
    // In this case it create logic to find employee by id. Optional<Employee> is for when not employee
    // can be found for that ID
    Optional<Employee> findEmployeeById(Long id);
}
