package com.codingshuttle.anuj.prod_ready_features.prod_ready_features;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.clients.EmployeeClient;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.dto.Employeedto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProdReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
//	@Order(3)
	void getAllEmployees(){
		List<Employeedto> employeedtoList = employeeClient.getAllEmployees();
		System.out.println(employeedtoList);
	}
	@Test
	@Order(2)
	void getEmployeeByIdTest(){
        Employeedto employeedto;
        employeedto = employeeClient.getEmployeeById(1L);
        System.out.println(employeedto);
	}

	@Test
	@Order(1)
	void createNewEmployeeTest(){
		Employeedto employeedto = new Employeedto(null,"RAM","ram@gmail.com",
				20, LocalDate.of(2020,12,1),true);
        Employeedto savedEmployeedto = employeeClient.createNewEmployee(employeedto);
        System.out.println(savedEmployeedto);
	}
}

