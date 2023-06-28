package com.travelatlasmorocco.entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@Entity(name = "user")
public class UserEntity  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    @Column(unique = true,  nullable = false ,length = 120)
    private String email;
    @Column(nullable = true)
    private Boolean admin = true;
    @Column(nullable = true)
    private String emailVerificationToken;
    @Column(nullable = false )
    private String ecryptyPassword;
    @Column(nullable = false)
    private Boolean emailVerificationStatus = false;


}
