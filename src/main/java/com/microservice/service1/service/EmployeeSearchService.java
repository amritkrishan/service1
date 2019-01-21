package com.microservice.service1.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.microservice.service1.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSearchService {
    private static Map<Long, Employee> EmployeeRepsitory = null;

    static {
        Employee emp1=createEmployee(1L,"Shamik  Mitra","Java","Architect");
        Employee emp2=createEmployee(2L,"Samir  Mitra","C++","Manager");
        Employee emp3=createEmployee(3L,"Swastika  Mitra","AI","Sr.Architect");
        EmployeeRepsitory=new HashMap<>();
        EmployeeRepsitory.put(emp1.getEmployeeId(),emp1);
        EmployeeRepsitory.put(emp2.getEmployeeId(),emp2);
        EmployeeRepsitory.put(emp3.getEmployeeId(),emp3);
    }

    private static Employee createEmployee(Long id, String name, String practiceArea, String designation) {
        Employee emp = new Employee();
        emp.setEmployeeId(id);
        emp.setName(name);
        emp.setPracticeArea(practiceArea);
        emp.setDesignation(designation);
        emp.setCompanyInfo("Cognizant");
        return emp;
    }

    public Employee findById(Long id) {
        return EmployeeRepsitory.get(id);
    }

    public Collection<Employee> findAll() {
        return EmployeeRepsitory.values();
    }
}
