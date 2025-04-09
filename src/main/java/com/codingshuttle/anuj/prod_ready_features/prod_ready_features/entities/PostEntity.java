package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.entities;

import jakarta.persistence.*;
//import lombok.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "posts")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
@Audited
public class PostEntity extends AuditableEntity{

    //    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    private String title;

    private String description;

    public PostEntity() {
    }

    // All-args constructor (for convenience)
    public PostEntity(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @PrePersist
//    void beforeSave(){
//
//    }
//
//    @PreUpdate
//    void beforeUpdate(){
//
//    }
//
//    @PostRemove
//    void beforeDelete(){
//
//    }
//


}
