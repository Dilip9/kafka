package edu.kfk.gouri.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_request", uniqueConstraints = @UniqueConstraint(columnNames = "username"), indexes = {
        @Index(name = "idx_user_request_username", columnList = "username"),
        @Index(name = "idx_user_request_email", columnList = "email"),
        @Index(name = "idx_user_request_phone_number", columnList = "phone_number")
})
public class UserRequest {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String username;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Password must be between 8 and 20 characters and contain only alphanumeric characters")
    private String phoneNumber;

    private String department;

    @Embedded
    private Auditable auditable;

}
