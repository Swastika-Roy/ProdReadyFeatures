package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.clients.impl;

import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.advice.ApiResponse;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.clients.EmployeeClient;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.dto.Employeedto;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);

    public EmployeeClientImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<Employeedto> getAllEmployees() {
        log.trace("Trying to retrieve all employees in getAllEmployees");
        try {
            log.info("Attempting to call the restClient Method in getAllEmployees");
            ApiResponse<List<Employeedto>> employeedtoList = restClient.get()
                    .uri("Employee")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res) -> {
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.debug("Successfully retrieved the employees in getAllEmployees");
            log.trace("Retrieved employees list in getAllEmployees : {}, {}, {}", employeedtoList.getData(), "Hello", 5);
            return employeedtoList.getData();
        }catch (Exception e) {
            log.error("Exception occured in getAllEmployees", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employeedto getEmployeeById(Long employeeId) {
        log.trace("Trying to get Employee By Id in getEmployeeById with id: {}", employeeId);
        try {
            ApiResponse<Employeedto> employeeResponse = restClient.get()
                    .uri("Employee/{employeeId}",employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res) -> {
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeResponse.getData();
        }catch (Exception e) {
            log.error("Exception occured in getAllEmployees", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employeedto createNewEmployee(Employeedto employeedto) {
        log.trace("Trying to create Employee with information {}", employeedto);
        try {
            ResponseEntity<ApiResponse<Employeedto>> employeedtoApiResponse = restClient.post()
                    .uri("Employee")
                    .body(employeedto)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.debug("4xxClient error occurred during createNewEmployee");
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res) -> {
                        System.out.println(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .toEntity(new ParameterizedTypeReference<>() {
                    });
            log.trace("Successfully created a new employee : {}", employeedtoApiResponse.getBody());
            return Objects.requireNonNull(employeedtoApiResponse.getBody()).getData();
        }catch (Exception e) {
            log.error("Exception occurred in createNewEmployee", e);
            throw new RuntimeException(e);
        }
    }
}
