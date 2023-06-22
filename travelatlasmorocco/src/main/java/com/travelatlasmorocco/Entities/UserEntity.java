package com.travelatlasmorocco.Entities;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity(name = "users")
public class UserEntity {
    @Id
    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private Boolean admin = false;
}
