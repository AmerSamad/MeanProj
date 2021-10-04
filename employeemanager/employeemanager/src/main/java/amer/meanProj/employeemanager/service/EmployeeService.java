package amer.meanProj.employeemanager.service;

import amer.meanProj.employeemanager.exception.UserNotFoundException;
import amer.meanProj.employeemanager.model.Employee;
import amer.meanProj.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee emp){
        emp.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(emp);
    }

    public List<Employee> findAllEmpoyees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee emp){
        return employeeRepo.save(emp);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
}
