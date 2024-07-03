package com.motorph.pms.service.impl;

<<<<<<< HEAD:backend/src/main/java/com/motorph/ems/service/impl/EmployeeServiceImpl.java
import com.motorph.pms.model.Benefits;
import com.motorph.pms.model.Employee;
import com.motorph.pms.model.Employment;
import com.motorph.pms.model.GovernmentId;
import com.motorph.pms.repository.BenefitsRepository;
import com.motorph.pms.repository.EmployeeRepository;
import com.motorph.pms.repository.EmploymentRepository;
import com.motorph.pms.repository.GovernmentIdRepository;
import com.motorph.pms.service.BenefitsService;
import com.motorph.pms.service.EmployeeService;
import com.motorph.pms.service.EmploymentService;
import com.motorph.pms.service.GovernmentIdService;
import com.motorph.pms.dto.EmployeeDTO;
import com.motorph.pms.dto.SupervisorDTO;
import com.motorph.pms.dto.mapper.EmployeeMapper;
import com.motorph.pms.model.Employee;
import com.motorph.pms.repository.EmployeeRepository;
import com.motorph.pms.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService, EmploymentService, GovernmentIdService, BenefitsService {

    private final EmployeeRepository employeeRepository;
    private final EmploymentRepository employmentRepository;
    private final GovernmentIdRepository governmentIdRepository;
    private final BenefitsRepository benefitsRepository;


    @Autowired
    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository,
            EmploymentRepository employmentRepository,
            GovernmentIdRepository governmentIdRepository,
            BenefitsRepository benefitsRepository
    ) {
        this.employeeRepository = employeeRepository;
        this.employmentRepository = employmentRepository;
        this.governmentIdRepository = governmentIdRepository;
        this.benefitsRepository = benefitsRepository;
    }

    @Override
    public void addNewEmployee(Employee employee) {
        System.out.println(employee.getEmployment().getSupervisor().getId());
        Employee supervisor = employeeRepository.findById(employee.getEmployment().getSupervisor().getId()).orElse(null);
        employee.getEmployment().setSupervisor(supervisor);
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long employeeID) {
        return employeeRepository.findById(employeeID).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployeesNameContains(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long employeeID) {
        Employee employee = getEmployeeById(employeeID);
        employeeRepository.delete(employee);
    }
    @Override
    public void addNewEmployeesFromCSV(String employeeCSVPath) {
        //TODO: implement adding employees from CSV
    }

    //EMPLOYMENT SERVICES
    @Override
    public Employment addNewEmployment(Employment employmentDetails) {
        return employmentRepository.save(employmentDetails);
    }

    @Override
    public Employment getEmploymentByEmployeeId(Long employeeID) {
        return employmentRepository.findById(employeeID).orElse(null);
    }

    @Override
    public Employment updateEmployment(Employment employmentDetails) {
        return employmentRepository.save(employmentDetails);
    }

    @Override
    public void deleteEmployment(Long employeeID) {
        employmentRepository.deleteById(employeeID);
    }

    //BENEFITS SERVICES
    @Override
    public void addNewBenefit(Benefits benefit) {
        benefitsRepository.save(benefit);
    }

    @Override
    public List<Benefits> getAllBenefits() {
        return benefitsRepository.findAll();
    }

    @Override
    public List<Benefits> getAllBenefitsByEmployeeId(Long employeeId) {
        return benefitsRepository.findAllById(Collections.singleton(employeeId));
    }

    @Override
    public Benefits getBenefitById(Long benefitId) {
        return benefitsRepository.findById(benefitId).orElse(null);
    }

    @Override
    public Benefits updateBenefit(Benefits updatedBenefit) {
        return benefitsRepository.save(updatedBenefit);
    }

    @Override
    public void deleteBenefit(Long benefitId) {
        benefitsRepository.deleteById(benefitId);
    }

    @Override
    public void deleteBenefitsByEmployeeId(Long employeeId) {
        benefitsRepository.deleteAllById(Collections.singleton(employeeId));
    }

    //GOVERNMENT ID SERVICES
    @Override
    public GovernmentId addNewGovernmentId(GovernmentId governmentIdDetails) {
        return governmentIdRepository.save(governmentIdDetails);
    }

    @Override
    public List<GovernmentId> getAllGovernmentIdByEmployeeId(Long employeeID) {
        return governmentIdRepository.findAllById(Collections.singleton(employeeID));
    }

    @Override
    public GovernmentId updateGovernmentId(GovernmentId governmentIdDetails) {
        return governmentIdRepository.save(governmentIdDetails);
    }

    @Override
    public void deleteGovernmentId(Long governmentId) {
        governmentIdRepository.deleteById(governmentId);
    }
}
