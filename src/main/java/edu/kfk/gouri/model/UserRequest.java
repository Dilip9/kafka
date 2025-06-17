package edu.kfk.gouri.model;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import lombok.Builder;

@Builder
public class UserRequest {

    private String username;

    @Email(message = "Invalid email format", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private Email email;

    private String phoneNumber;

    private String department;

    @Embedded
    private Auditable auditable;

}
