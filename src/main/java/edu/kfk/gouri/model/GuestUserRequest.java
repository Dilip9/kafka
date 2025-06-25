package edu.kfk.gouri.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "guest_user_request", indexes = {
        @Index(name = "idx_guest_user_request_email", columnList = "email"),
        @Index(name = "idx_guest_user_request_username", columnList = "username"),
        @Index(name = "idx_guest_user_request_ip_address", columnList = "ipAddress")})
public class GuestUserRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Email(message = "Email should be valid")
    private String email;

    @Column(unique = true)
    private String username;

    @Column(unique = true, nullable = false)
    private String ipAddress;

    @Column(name = "country", nullable = true, length = 100)
    private String country;
}
