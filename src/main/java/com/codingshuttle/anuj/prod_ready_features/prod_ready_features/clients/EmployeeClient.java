package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.clients;

import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.dto.Employeedto;

import java.util.List;

public interface EmployeeClient {

    List<Employeedto> getAllEmployees();

    Employeedto getEmployeeById(Long employeeId);

    Employeedto createNewEmployee(Employeedto employeedto);

}
