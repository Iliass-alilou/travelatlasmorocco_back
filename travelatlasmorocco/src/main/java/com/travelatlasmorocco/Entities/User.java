package com.travelatlasmorocco.Entities;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class User {
    @Id
    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private Boolean admin = false;
}
