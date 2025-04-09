package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employeedto {
    private Long id;

    private String name;

    private String email;

    private Integer age;

//    private String role;
//
//    private Double Salary;

    private LocalDate dateOfJoining;

    private Boolean Isative;

    public Employeedto(Long id, String name, String email, Integer age,
                       LocalDate dateOfJoining, Boolean isative) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.Isative = isative;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getIsative() {
        return Isative;
    }

    public void setIsative(Boolean isative) {
        Isative = isative;
    }
}

