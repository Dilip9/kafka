package edu.kfk.gouri.model;

import edu.kfk.gouri.model.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @Column(unique = true, nullable = false, name = "username")
    private String username;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Password must be between 8 and 20 characters and contain only alphanumeric characters")
    private String phoneNumber;

    @Column(nullable = false, name="department")
    private String department;

    @Column(nullable = false, name="role")
    private Roles role;

}
