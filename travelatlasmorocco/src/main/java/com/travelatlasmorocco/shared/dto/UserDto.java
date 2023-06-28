package com.travelatlasmorocco.shared.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class UserDto implements Serializable {
    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean admin;
    private String password;
    private String ecryptyPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return id == userDto.id && Objects.equals(userId, userDto.userId) && Objects.equals(firstName, userDto.firstName) && Objects.equals(lastName, userDto.lastName) && Objects.equals(email, userDto.email) && Objects.equals(admin, userDto.admin) && Objects.equals(password, userDto.password) && Objects.equals(ecryptyPassword, userDto.ecryptyPassword) && Objects.equals(emailVerificationToken, userDto.emailVerificationToken) && Objects.equals(emailVerificationStatus, userDto.emailVerificationStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, firstName, lastName, email, admin, password, ecryptyPassword, emailVerificationToken, emailVerificationStatus);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", admin=" + admin +
                ", password='" + password + '\'' +
                ", ecryptyPassword='" + ecryptyPassword + '\'' +
                ", emailVerificationToken='" + emailVerificationToken + '\'' +
                ", emailVerificationStatus=" + emailVerificationStatus +
                '}';
    }
}
