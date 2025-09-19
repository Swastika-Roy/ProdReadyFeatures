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

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "posts")

@Audited
public class PostEntity extends AuditableEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    private String title;

    private String description;

    public PostEntity() {
    }


    public PostEntity(Long id, String title, String description) {
        this.id = id;
        this.title = title;
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
